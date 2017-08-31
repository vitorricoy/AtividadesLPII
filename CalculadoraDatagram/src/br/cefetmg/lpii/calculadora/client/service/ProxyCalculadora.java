/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.service;

import br.cefetmg.lpii.calculadora.client.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoCalculadora;
import br.cefetmg.lpii.calculadora.model.exception.ExcecaoConexao;
import br.cefetmg.lpii.calculadora.model.service.Calculadora;
/**
 *
 * @author Aluno
 */
public class ProxyCalculadora implements Calculadora{
    Comunicacao com;

    public ProxyCalculadora() throws ExcecaoCalculadora{
        try {
            com = new Comunicacao();
        } catch (ExcecaoConexao ex) {
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        }
    }
    
    @Override
    public double soma(double x, double y) throws ExcecaoCalculadora {
        try{
            com.enviarDados(x, y, '+');
            System.out.println("Enviou dados");
            double res = (Double)com.receberDados();
            System.out.println("Recebeu resposta");
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    @Override
    public double subtracao(double x, double y) throws ExcecaoCalculadora {
        try{
            com.enviarDados(x, y, '-');
            double res = (Double)com.receberDados();
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    @Override
    public double multiplicacao(double x, double y) throws ExcecaoCalculadora {
        try{
            com.enviarDados(x, y, '*');
            double res = (Double)com.receberDados();
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    @Override
    public double divisao(double x, double y) throws ExcecaoCalculadora {
        try{
            com.enviarDados(x, y, '/');
            double res = (Double)com.receberDados();
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    public Comunicacao getCom() {
        return com;
    }
    
}
