/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.comunicacao;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Aluno
 */
public class Comunicacao {
    private String ip;
    private int porta;
    private Socket c;

    public Comunicacao(String ip, int porta) throws ExcecaoConexao {
        this.ip = ip;
        this.porta = porta;
        try {
            c = new Socket(ip, porta);
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao conectar ao servidor ("+ip+", "+porta+")");
        }
    }
    
    public Comunicacao() throws ExcecaoConexao {
        this("localhost", 2222);
    }
    
    public void enviarObjeto(Object o) throws ExcecaoConexao{
        ObjectOutputStream saida;
        try {
            saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeObject(o);
            saida.flush();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao enviar objeto ao servidor ("+ip+", "+porta+")");
        }
    }
    
    public Object receberObjeto() throws ExcecaoConexao, ClassNotFoundException{
        try {
            ObjectInputStream entrada = new ObjectInputStream (c.getInputStream());
            return entrada.readObject();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao receber objeto do servidor ("+ip+", "+porta+")");
        }
    }
    
    public void fecharConexao() throws ExcecaoConexao{
        try {
            c.close();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao fechar conexão");
        }
    }
    
}
