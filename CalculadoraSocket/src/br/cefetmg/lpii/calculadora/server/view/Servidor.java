/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.view;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.server.service.CalculadoraImpl;

/**
 *
 * @author Aluno
 */
public class Servidor {
    public static void main(String[] args){
        while(true){
            try {
                System.out.println("Esperando conexão");
                CalculadoraImpl calc = new CalculadoraImpl();
                Comunicacao com = new Comunicacao();
                calc.setCom(com);
                Thread requisicao = new Thread(calc);
                requisicao.start();
            } catch (ExcecaoConexao ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
    }
}
