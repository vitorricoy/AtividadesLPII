/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.server.comunicacao;

import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Comunicacao {
    private int porta;
    private Socket c;
    private ServerSocket s;
    
    public Comunicacao(int porta) throws ExcecaoConexao {
        this.porta = porta;
        try {
            s = new ServerSocket(porta);
            c = s.accept();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao escutar e aceitar conexão na porta: " +porta);
        }
    }
    
    public Comunicacao() throws ExcecaoConexao {
        this(2222);
    }
    
    public void enviarObjeto(Object o) throws ExcecaoConexao{
        ObjectOutputStream saida;
        try {
            saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeObject(o);
            saida.flush();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao enviar objeto ao cliente");
        }
    }
    
    public Object receberObjeto() throws ExcecaoConexao{
        try {
            ObjectInputStream entrada = new ObjectInputStream (c.getInputStream());
            return entrada.readObject();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao receber objeto do cliente");
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoConexao("Erro de classe ao receber o objeto do cliente");
        }
    }
    
    public void fecharConexao() throws ExcecaoConexao{
        try {
            s.close();
            c.close();
        } catch (IOException ex) {
            throw new ExcecaoConexao("Erro ao fechar conexão");
        }
    }
}
