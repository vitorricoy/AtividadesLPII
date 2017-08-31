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
    private int cliente;
    private double a;
    private double b;
    
    public AdapterCalculadora(int cliente, double a, double b, char op) {
        calc = new CalculadoraImpl();
        this.a=a;
        this.b=b;
        this.op=op;
        this.cliente=cliente;
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
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
                    com.enviarDados(calc.soma(a, b), com.getClientes().get(cliente), 2223);
                    System.out.println("Enviou resposta para " + com.getClientes().get(cliente));
                    break;
                case '-':
                    com.enviarDados(calc.subtracao(a, b), com.getClientes().get(cliente), 2223);
                    System.out.println("Enviou resposta para " + com.getClientes().get(cliente));
                    break;
                case '*':
                    com.enviarDados(calc.multiplicacao(a, b), com.getClientes().get(cliente), 2223);
                    System.out.println("Enviou resposta para " + com.getClientes().get(cliente));
                    break;
                case '/':
                    com.enviarDados(calc.divisao(a, b), com.getClientes().get(cliente), 2223);
                    System.out.println("Enviou resposta para " + com.getClientes().get(cliente));
                    break;
            }
        } catch (ExcecaoConexao | ExcecaoCalculadora ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
