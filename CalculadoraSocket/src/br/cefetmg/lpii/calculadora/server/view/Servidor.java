/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.view;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.server.service.AdapterCalculadora;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Aluno
 */
public class Servidor {
    public static void main(String[] args){
        ServerSocket s = null;
        try {
            s = new ServerSocket(2222);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            System.exit(0);
        }
        while(true){
            try {
                System.out.println("Esperando conexão");
                AdapterCalculadora calc = new AdapterCalculadora();
                Comunicacao com = new Comunicacao(s.accept());
                calc.setCom(com);
                Thread requisicao = new Thread(calc);
                requisicao.start();
            } catch (ExcecaoConexao | IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
    }
}
