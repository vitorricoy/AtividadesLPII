/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.view;

import br.cefetmg.lpii.calculadora.client.service.ProxyCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Cliente {
    public static void main(String[] args){
        int op;
        Scanner s = new Scanner(System.in);
        do{
            System.out.print("\n1- Soma\n2- Subtração\n3- Multiplicação\n4- Divisão\nEscolha a operação: ");
            op=s.nextInt();
        }while(op<1 || op>6);
        try {
            Calculadora calc = new ProxyCalculadora();
            double a=0, b=0, c=0;
            double resultado;
            switch(op){
                case 1: 
                    System.out.print("\nDigite o primeiro numero: ");
                    a = s.nextDouble();
                    System.out.print("\nDigite o segundo numero: ");
                    b = s.nextDouble();
                    resultado = calc.soma(a, b);
                    System.out.println("\nO resultado é: " + resultado);
                    break;
                case 2: 
                    System.out.print("\nDigite o primeiro numero: ");
                    a = s.nextDouble();
                    System.out.print("\nDigite o segundo numero: ");
                    b = s.nextDouble();
                    resultado = calc.subtracao(a, b);
                    System.out.println("\nO resultado é: " + resultado);
                    break;
                case 3:
                    System.out.print("\nDigite o primeiro numero: ");
                    a = s.nextDouble();
                    System.out.print("\nDigite o segundo numero: ");
                    b = s.nextDouble();
                    resultado = calc.multiplicacao(a, b);
                    System.out.println("\nO resultado é: " + resultado);
                    break;
                case 4:
                    System.out.print("\nDigite o primeiro numero: ");
                    a = s.nextDouble();
                    while(b==0){
                        System.out.print("\nDigite o segundo numero: ");
                        b = s.nextDouble();
                    }
                    resultado = calc.divisao(a, b);
                    System.out.println("\nO resultado é: " + resultado);
                    break;
            }
        } catch (ExcecaoCalculadora ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }
}
