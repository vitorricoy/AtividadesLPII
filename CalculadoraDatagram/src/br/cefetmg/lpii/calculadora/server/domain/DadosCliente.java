/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.domain;

/**
 *
 * @author umcan
 */
public class DadosCliente {
    public char op;
    public double a;
    public double b;
    public String ip;
    public int porta;

    public DadosCliente(char op, double a, double b, String ip, int porta) {
        this.op = op;
        this.a = a;
        this.b = b;
        this.ip = ip;
        this.porta = porta;
    }
    
}
