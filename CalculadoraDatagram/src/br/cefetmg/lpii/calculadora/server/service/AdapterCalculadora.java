/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.service;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;

/**
 *
 * @author aluno
 */
public class AdapterCalculadora implements Runnable{
    
    private Comunicacao com;
    private CalculadoraImpl calc;
    private char op;
    private int porta;
    private String ip;
    private double a;
    private double b;
    
    public AdapterCalculadora(int porta, String ip, double a, double b, char op) {
        calc = new CalculadoraImpl();
        this.a=a;
        this.b=b;
        this.op=op;
        this.ip=ip;
        this.porta=porta;
    }
    
    public Comunicacao getCom() {
        return com;
    }

    public void setCom(Comunicacao com) {
        this.com = com;
    }

    public CalculadoraImpl getCalc() {
        return calc;
    }

    public void setCalc(CalculadoraImpl calc) {
        this.calc = calc;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread");
            switch (op) {
                case '+':
                    com.enviarDados(calc.soma(a, b), ip, porta);
                    break;
                case '-':
                    com.enviarDados(calc.subtracao(a, b), ip, porta);
                    break;
                case '*':
                    com.enviarDados(calc.multiplicacao(a, b), ip, porta);
                    break;
                case '/':
                    com.enviarDados(calc.divisao(a, b), ip, porta);
                    break;
            }
        } catch (ExcecaoConexao | ExcecaoCalculadora ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
