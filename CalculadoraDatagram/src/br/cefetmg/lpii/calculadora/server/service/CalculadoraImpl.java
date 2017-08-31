/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.service;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;

/**
 *
 * @author Aluno
 */
public class CalculadoraImpl implements Calculadora{

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

}
