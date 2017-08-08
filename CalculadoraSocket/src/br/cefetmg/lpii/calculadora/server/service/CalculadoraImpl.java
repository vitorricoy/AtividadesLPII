/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.service;

import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.model.domain.RaizesBhaskara;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CalculadoraImpl implements Calculadora, Runnable {

    private Comunicacao com;

    @Override
    public double soma(double x, double y) throws ExcecaoCalculadora {
        return x + y;
    }

    @Override
    public double subtracao(double x, double y) throws ExcecaoCalculadora {
        return x - y;
    }

    @Override
    public double multiplicacao(double x, double y) throws ExcecaoCalculadora {
        return x * y;
    }

    @Override
    public double divisao(double x, double y) throws ExcecaoCalculadora {
        return x / y;
    }

    @Override
    public Double[][] multiplicacaoMatriz(Double[][] a, Double[][] b) throws ExcecaoCalculadora {
        Double[][] res = new Double[a.length][b[0].length];
        for (int I = 0; I < res.length; I++) {
            for (int J = 0; J < res[0].length; J++) {
                res[I][J] = new Double(0);
            }
        }
        for (int I = 0; I < a.length; I++) {
            for (int J = 0; J < b[0].length; J++) {
                for (int K = 0; K < a[0].length; K++) {
                    res[I][J] += a[I][K] * b[K][J];
                }
            }
        }
        return res;
    }

    @Override
    public RaizesBhaskara bhaskara(double a, double b, double c) throws ExcecaoCalculadora {
        double delta = b * b + (-4 * a * c);
        if (delta > 0) {
            double x1 = ((-1 * b) + Math.sqrt(delta)) / (2 * a);
            double x2 = ((-1 * b) - Math.sqrt(delta)) / (2 * a);
            return new RaizesBhaskara(x1, x2, true);
        } else {
            return new RaizesBhaskara(0, 0, false);
        }
    }

    public Comunicacao getCom() {
        return com;
    }

    public void setCom(Comunicacao com) {
        this.com = com;
    }

    @Override
    public void run() {
        try {
            int op = (Integer) com.receberObjeto();
            double a, b, c;
            switch (op) {
                case 1:
                    a = (Double) com.receberObjeto();
                    b = (Double) com.receberObjeto();
                    com.enviarObjeto(soma(a, b));
                    break;
                case 2:
                    a = (Double) com.receberObjeto();
                    b = (Double) com.receberObjeto();
                    com.enviarObjeto(subtracao(a, b));
                    break;
                case 3:
                    a = (Double) com.receberObjeto();
                    b = (Double) com.receberObjeto();
                    com.enviarObjeto(multiplicacao(a, b));
                    break;
                case 4:
                    a = (Double) com.receberObjeto();
                    b = (Double) com.receberObjeto();
                    com.enviarObjeto(divisao(a, b));
                    break;
                case 5:
                    Double[][] matrizA,
                            matrizB;
                    matrizA = (Double[][]) com.receberObjeto();
                    matrizB = (Double[][]) com.receberObjeto();
                    for (int I = 0; I < matrizA.length; I++) {
                        for (int J = 0; J < matrizA[0].length; J++) {
                            System.out.print(matrizA[I][J] + " ");
                        }
                        System.out.println("");
                    }
                    for (int I = 0; I < matrizB.length; I++) {
                        for (int J = 0; J < matrizB[0].length; J++) {
                            System.out.print(matrizB[I][J] + " ");
                        }
                        System.out.println("");
                    }
                    Double[][] res = multiplicacaoMatriz(matrizA, matrizB);
                    com.enviarObjeto(res);
                    break;
                case 6:
                    a = (Double) com.receberObjeto();
                    b = (Double) com.receberObjeto();
                    c = (Double) com.receberObjeto();
                    com.enviarObjeto(bhaskara(a, b, c));
                    break;
            }   
            com.fecharConexao();
        } catch (ExcecaoConexao | ExcecaoCalculadora ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

}
