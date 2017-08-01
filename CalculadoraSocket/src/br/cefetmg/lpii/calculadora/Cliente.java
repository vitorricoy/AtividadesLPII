/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Cliente {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
	try{		
            System.out.println("Conectando ao servidor");
            Socket c = new Socket ("localhost", 2222);
            
            ObjectOutputStream saida = new ObjectOutputStream(c.getOutputStream());
            String op;
            boolean errado=true;
            do{
               System.out.println("Digite a operação a ser feita (+, -, * ou /)");
               op = s.nextLine();
               if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
                   errado=false;
               }else{
                   System.out.println("Operação inválida!");
               }
            }while(errado);
            saida.writeObject(op);//ESCREVE NO PACOTE
            System.out.println("Enviando operação");
            saida.flush();
            
            saida = new ObjectOutputStream(c.getOutputStream());
            Double num1=null;
            while(num1==null){
                System.out.println("Digite o primeiro numero");
                num1 = s.nextDouble();
            }
            saida.writeObject(num1);
            System.out.println("Enviando numero 1");
            saida.flush();
            
            saida = new ObjectOutputStream(c.getOutputStream());
            Double num2=null;
            while(num2==null){
                System.out.println("Digite o segundo numero");
                num2 = s.nextDouble();
            }
            saida.writeObject(num2);
            System.out.println("Enviando numero 2");
            saida.flush();
            
            ObjectInputStream entrada = new ObjectInputStream (c.getInputStream());
            System.out.println("Recebendo resultado");
            String t = entrada.readObject().toString();
            System.out.println("Resultado: " + t);

            c.close();
            System.out.println("Conexao terminada");
	}
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
	}
    }
}
