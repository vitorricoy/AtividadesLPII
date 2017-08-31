/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.comunicacao;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.util.ByteConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Aluno
 */
public class Comunicacao {
    private String ip;
    private int porta;
    private InetAddress address;
    private DatagramSocket c;
    private int idCliente;

    public Comunicacao(String ip, int porta) throws ExcecaoConexao {
        this.ip = ip;
        this.porta = porta;
        try {
            c = new DatagramSocket(2222);
            byte[] buf = new byte[32];
            address = InetAddress.getByName(ip);
            System.arraycopy(ByteConverter.toByteArray(-1), 0, buf, 0, 8);
            DatagramPacket packet = new DatagramPacket(buf, 32, address, porta);
            c.send(packet);
            byte[] buff=new byte[8];
            packet = new DatagramPacket(buff, 8);
            c.receive(packet);
            idCliente = ByteConverter.toInt(buff);
        } catch (IOException ex) {
            throw new ExcecaoConexao(ex.getMessage());
        }
    }
    
    public Comunicacao() throws ExcecaoConexao {
        this("localhost", 2223);
    }
    
    public void enviarDados(double a, double b, char op) throws ExcecaoConexao{
        byte[] arr = new byte[32];
        byte[] aux;
        try {
            aux = ByteConverter.toByteArray(idCliente);
            System.arraycopy(aux, 0, arr, 0, 8);
            aux = ByteConverter.toByteArray(op);
            System.arraycopy(aux, 0, arr, 8, 8);
            aux = ByteConverter.toByteArray(a);
            System.arraycopy(aux, 0, arr, 16, 8);
            aux = ByteConverter.toByteArray(b);
            System.arraycopy(aux, 0, arr, 24, 8);
            DatagramPacket packet = new DatagramPacket(arr, 32, address, porta);
            c.send(packet);
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao enviar objeto ao servidor ("+ip+", "+porta+")");
        }
    }
    
    public double receberDados() throws ExcecaoConexao, ClassNotFoundException{
        byte[] buf = new byte[8];
        try {
            DatagramPacket packet = new DatagramPacket(buf, 8);
            c.receive(packet);
            return ByteConverter.toDouble(buf);
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao receber objeto do servidor ("+ip+", "+porta+")");
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public DatagramSocket getC() {
        return c;
    }

    public void setC(DatagramSocket c) {
        this.c = c;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
