/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.view;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.server.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.server.service.AdapterCalculadora;
import br.cefetmg.lpii.calculadora.util.ByteConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Aluno
 */
public class Servidor {
    public static void main(String[] args){
        DatagramSocket s = null;
        try {
            s= new DatagramSocket(2223);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            System.exit(0);
        }
        Comunicacao com=null;
        try {
            com = new Comunicacao(s, 2223, "localhost");
        } catch (ExcecaoConexao ex) {
            System.out.println("Erro: " + ex.getMessage());
            System.exit(0);
        }
        while(true){
            try {
                byte[] arr = new byte[32];
                DatagramPacket packet = new DatagramPacket(arr, 32);
                System.out.println("Esperando");
                s.receive(packet);
                System.out.println("Recebeu");
                byte[] id = new byte[8];
                System.arraycopy(arr, 0, id, 0, 8);
                if(ByteConverter.toInt(id)==-1){
                    com.getClientes().add(packet.getAddress().getHostAddress());
                    DatagramPacket packetResp = new DatagramPacket(ByteConverter.toByteArray(com.getClientes().size()-1), 8, packet.getAddress(), packet.getPort());
                    s.send(packetResp);
                }else{
                    byte[] op = new byte[8];
                    System.arraycopy(arr, 8, op, 0, 8);
                    byte[] a = new byte[8];
                    System.arraycopy(arr, 16, a, 0, 8);
                    byte[] b = new byte[8];
                    System.arraycopy(arr, 24, b, 0, 8);
                    System.out.println("Id = " + ByteConverter.toInt(id) + "\nA = " + ByteConverter.toDouble(a) + "\nB = " + ByteConverter.toDouble(b) + "\nOp = " + ByteConverter.toChar(op));
                    AdapterCalculadora calc = new AdapterCalculadora(ByteConverter.toInt(id), ByteConverter.toDouble(a), ByteConverter.toDouble(b), ByteConverter.toChar(op));
                    calc.setCom(com);
                    Thread requisicao = new Thread(calc);
                    requisicao.start();
                } 
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
    }
}
