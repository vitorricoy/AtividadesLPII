/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aluno
 */
public class Servidor {

    public static void main(String[] args) {
        try{
            System.out.println("Aguardando conexão");
            ServerSocket s = new ServerSocket(2222);
            
            Socket p = s.accept();
            System.out.println("Conectado ao cliente: " + p.toString());
            
            System.out.println("Recebendo operação");
            ObjectInputStream entrada = new ObjectInputStream(p.getInputStream());
            String op = (String)entrada.readObject();
            System.out.println("Recebendo numero 1");
            entrada = new ObjectInputStream(p.getInputStream());
            Double num1 = (Double)entrada.readObject();
            System.out.println("Recebendo numero 2");
            entrada = new ObjectInputStream(p.getInputStream());
            Double num2 = (Double)entrada.readObject();
            Double res=null;
            switch(op){
                case "+": res=num1+num2; break;
                case "-": res=num1-num2; break;
                case "/": res=num1/num2; break;
                case "*": res=num1*num2; break;
            }
            ObjectOutputStream saida = new ObjectOutputStream(p.getOutputStream());
            saida.writeObject(res.toString());
            System.out.println("Enviando resultado");
            saida.flush();
            s.close();
            p.close();
            System.out.println("Conexão terminada");
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
