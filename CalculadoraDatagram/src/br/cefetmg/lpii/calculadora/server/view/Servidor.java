/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.view;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.server.domain.DadosCliente;
import br.cefetmg.lpii.calculadora.server.service.AdapterCalculadora;
import br.cefetmg.lpii.calculadora.util.ByteConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Servidor {
    public static void main(String[] args){ 
        Comunicacao com=null;
        try {
            com=new Comunicacao();
        } catch (ExcecaoConexao ex) {
            System.out.println("Erro: " + ex.getMessage());
            System.exit(0);
        }
        while(true){
            try {
                DadosCliente d;
                System.out.println("Esperando");
                d=com.receberDados();
                System.out.println("Recebeu");
                AdapterCalculadora calc = new AdapterCalculadora(d.porta, d.ip, d.a, d.b, d.op);
                calc.setCom(com);
                Thread requisicao = new Thread(calc);
                requisicao.start();
                 
            } catch (ExcecaoConexao ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
    }
}
