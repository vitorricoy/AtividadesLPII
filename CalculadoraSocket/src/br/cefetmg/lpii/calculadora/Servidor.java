/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora;

import java.io.ObjectInputStream;
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
            
            ObjectInputStream entrada = new ObjectInputStream(p.getInputStream());
            System.out.println("Recebendo operação");
            String op = (String)entrada.readObject();
            System.out.println("Recebendo numero 1");
            switch(op){
                case "+":
                case "-":
                case "/":
                case "*":
            }
        }catch(Exception e){
            
        }
    }
    
}
