/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.view;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.server.service.CalculadoraImpl;

/**
 *
 * @author Aluno
 */
public class Servidor {
    public static void main(String[] args){
        System.out.println("Esperando conexão");
        Calculadora calc = new CalculadoraImpl();
        try {
            Comunicacao com = new Comunicacao();
            int op = (Integer) com.receberObjeto();
            double a, b, c;
            switch(op){
                case 1:
                    a = (Double)com.receberObjeto();
                    b = (Double)com.receberObjeto();
                    com.enviarObjeto(calc.soma(a, b));
                    break;
                case 2:
                    a = (Double)com.receberObjeto();
                    b = (Double)com.receberObjeto();
                    com.enviarObjeto(calc.subtracao(a, b));
                    break;
                case 3:
                    a = (Double)com.receberObjeto();
                    b = (Double)com.receberObjeto();
                    com.enviarObjeto(calc.multiplicacao(a, b));
                    break;
                case 4:
                    a = (Double)com.receberObjeto();
                    b = (Double)com.receberObjeto();
                    com.enviarObjeto(calc.divisao(a, b));
                    break;
                case 5:
                    Double[][] matrizA, matrizB;
                    matrizA = (Double[][])com.receberObjeto();
                    matrizB = (Double[][])com.receberObjeto();
                    for(int I=0; I<matrizA.length; I++){
                        for(int J=0; J<matrizA[0].length; J++){
                            System.out.print(matrizA[I][J]+ " ");
                        }
                        System.out.println("");
                    }
                    for(int I=0; I<matrizB.length; I++){
                        for(int J=0; J<matrizB[0].length; J++){
                            System.out.print(matrizB[I][J]+ " ");
                        }
                        System.out.println("");
                    }
                    Double[][] res = calc.multiplicacaoMatriz(matrizA, matrizB);
                    com.enviarObjeto(res);
                    break;
                case 6:
                    a = (Double)com.receberObjeto();
                    b = (Double)com.receberObjeto();
                    c = (Double)com.receberObjeto();
                    com.enviarObjeto(calc.bhaskara(a, b, c));
                    break;
            }
            com.fecharConexao();
        } catch (ExcecaoConexao | ExcecaoCalculadora ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }
}
