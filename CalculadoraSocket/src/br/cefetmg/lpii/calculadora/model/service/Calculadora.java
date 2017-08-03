/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.model.service;

import br.cefetmg.lpii.calculadora.model.domain.RaizesBhaskara;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;

/**
 *
 * @author Aluno
 */
public interface Calculadora {
    public double soma(double x, double y) throws ExcecaoCalculadora;
    public double subtracao(double x, double y) throws ExcecaoCalculadora;
    public double multiplicacao(double x, double y) throws ExcecaoCalculadora;
    public double divisao(double x, double y) throws ExcecaoCalculadora;
    public Double[][] multiplicacaoMatriz(Double[][] a, Double[][] b) throws ExcecaoCalculadora;
    public RaizesBhaskara bhaskara(double a, double b, double c) throws ExcecaoCalculadora;
    
}
