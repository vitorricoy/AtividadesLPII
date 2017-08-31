/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.comunicacao;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.util.ByteConverter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Comunicacao {
    private int porta;
    private DatagramSocket c;
    private String ip;
    private InetAddress address;
    private List<String> clientes;
    
    public Comunicacao(int porta, String ip) throws ExcecaoConexao{
        try {
            c=new DatagramSocket(porta);
            address = InetAddress.getByName(ip);
            clientes = new ArrayList<>();
        } catch (SocketException | UnknownHostException ex) {
            throw new ExcecaoConexao(ex.getMessage());
        }
    }
    
    public Comunicacao(DatagramSocket c, int porta, String ip) throws ExcecaoConexao{
        try {
            this.c=c;
            address = InetAddress.getByName(ip);
            clientes = new ArrayList<>();
        } catch (UnknownHostException ex) {
            throw new ExcecaoConexao(ex.getMessage());
        }
    }
    
    public Comunicacao() throws ExcecaoConexao{
        this(2223, "localhost");
    }
    
    public void enviarDados(double res, String ip, int porta) throws ExcecaoConexao{
        try {
            DatagramPacket packet = new DatagramPacket(ByteConverter.toByteArray(res), 8, InetAddress.getByName(ip), 2222);
            c.send(packet);
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao enviar objeto ao cliente");
        }
    }
    
    public byte[] receberDados() throws ExcecaoConexao{
        byte[] buf = new byte[32];
        try {
            DatagramPacket packet = new DatagramPacket(buf, 32);
            c.receive(packet);
            return buf;
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao receber objeto do servidor ("+ip+", "+porta+")");
        }
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public DatagramSocket getC() {
        return c;
    }

    public void setC(DatagramSocket c) {
        this.c = c;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public List<String> getClientes() {
        return clientes;
    }

    public void setClientes(List<String> clientes) {
        this.clientes = clientes;
    }
    
}
