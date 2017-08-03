/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.model.domain;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class RaizesBhaskara implements Serializable{
    private double raiz1;
    private double raiz2;
    private boolean existe;

    public RaizesBhaskara(double raiz1, double raiz2, boolean existe) {
        this.raiz1 = raiz1;
        this.raiz2 = raiz2;
        this.existe = existe;
    }

    public double getRaiz1() {
        return raiz1;
    }

    public void setRaiz1(double raiz1) {
        this.raiz1 = raiz1;
    }

    public double getRaiz2() {
        return raiz2;
    }

    public void setRaiz2(double raiz2) {
        this.raiz2 = raiz2;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    
}
