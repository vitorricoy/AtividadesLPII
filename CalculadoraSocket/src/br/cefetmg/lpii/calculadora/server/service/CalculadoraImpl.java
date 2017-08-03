/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.service;

import br.cefetmg.lpii.calculadora.model.domain.RaizesBhaskara;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;

/**
 *
 * @author Aluno
 */
public class CalculadoraImpl implements Calculadora{

    @Override
    public double soma(double x, double y) throws ExcecaoCalculadora {
        return x+y;
    }

    @Override
    public double subtracao(double x, double y) throws ExcecaoCalculadora {
        return x-y;
    }

    @Override
    public double multiplicacao(double x, double y) throws ExcecaoCalculadora {
        return x*y;
    }

    @Override
    public double divisao(double x, double y) throws ExcecaoCalculadora {
        return x/y;
    }

    @Override
    public Double[][] multiplicacaoMatriz(Double[][] a, Double[][] b) throws ExcecaoCalculadora {
        Double[][] res = new Double[a[0].length][b.length];
        for (int i=0; i < a.length; i++){
            for (int j= 0; j < b[0].length; j++){
		for (int x= 0; x < a[j][j]; x++){
                    res[i][j] += a[i][x] * b[x][j];
                }
            }
	}
        return res;
    }

    @Override
    public RaizesBhaskara bhaskara(double a, double b, double c) throws ExcecaoCalculadora {
        double delta = b*b + (-4*a*c);
        if(delta>0){
            double x1 = ((-1*b)+Math.sqrt(delta))/(2*a);
            double x2 = ((-1*b)-Math.sqrt(delta))/(2*a);
            return new RaizesBhaskara(x1, x2, true);
        }else{
            return new RaizesBhaskara(0, 0, false);
        }
    }
    
}
