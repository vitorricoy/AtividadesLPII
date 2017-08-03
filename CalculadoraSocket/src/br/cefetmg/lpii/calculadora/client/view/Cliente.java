/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.view;

import br.cefetmg.lpii.calculadora.client.service.ProxyCalculadora;
import br.cefetmg.lpii.calculadora.model.domain.RaizesBhaskara;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
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
            System.out.print("\n1- Soma\n2- Subtração\n3- Multiplicação\n4- Divisão\n5- Multiplicação de Matrizes\n6- Resolver Equação de Segundo Grau\nEscolha a operação: ");
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
                case 5: 
                    int x1, y1;
                    System.out.print("\nDigite a quantidade de linhas da matriz a: ");
                    x1 = s.nextInt();
                    System.out.print("\nDigite a quantidade de colunas da matriz a: ");
                    y1 = s.nextInt();
                    Double[][] matrizA = new Double[x1][y1];
                    for(int I=0; I<x1; I++){
                        for(int J=0; J<y1; J++){
                            System.out.print("\nDigite o valor da linha " + (I+1) + " e da coluna " + (J+1) + " da matriz a: ");
                            matrizA[I][J] = s.nextDouble();
                        }
                    }
                    int x2, y2;
                    System.out.print("\nDigite a quantidade de linhas da matriz b: ");
                    x2 = s.nextInt();
                    System.out.print("\nDigite a quantidade de colunas da matriz b: ");
                    y2 = s.nextInt();
                    Double[][] matrizB = new Double[x2][y2];
                    for(int I=0; I<x2; I++){
                        for(int J=0; J<y2; J++){
                            System.out.print("\nDigite o valor da linha " + (I+1) + " e da coluna " + (J+1) + " da matriz b: ");
                            matrizB[I][J] = s.nextDouble();
                        }
                    }
                    if(y1==x2){
                        Double[][] res = calc.multiplicacaoMatriz(matrizA, matrizB);
                        System.out.println("O resultado é: ");
                        for(int I=0; I<x1; I++){
                            for(int J=0; J<y2; J++){
                                System.out.print(res[I][J]+ " ");
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Dimensões incorretas");
                    }
                    
                    break;
                case 6: 
                    System.out.print("\nDigite o termo a: ");
                    a = s.nextDouble();
                    System.out.print("\nDigite o termo b: ");
                    b = s.nextDouble();
                    System.out.print("\nDigite o termo c: ");
                    c = s.nextDouble();
                    RaizesBhaskara resul = calc.bhaskara(a, b, c);
                    if(resul.isExiste()){
                        System.out.println("O resultado é: \nx1 = "+resul.getRaiz1() + "\nx2 = " + resul.getRaiz2());
                    }else{
                        System.out.println("Raizes Inexistentes");
                    }
                    break;
            }
            ((ProxyCalculadora)(calc)).getCom().fecharConexao();
        } catch (ExcecaoCalculadora | ExcecaoConexao ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }
}
