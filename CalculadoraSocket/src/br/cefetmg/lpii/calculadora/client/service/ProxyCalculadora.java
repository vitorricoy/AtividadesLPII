/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.client.service;

import br.cefetmg.lpii.calculadora.client.comunicacao.Comunicacao;
import br.cefetmg.lpii.calculadora.model.domain.RaizesBhaskara;
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
            com.enviarObjeto(1);
            com.enviarObjeto(x);
            com.enviarObjeto(y);
            double res = (Double)com.receberObjeto();
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
            com.enviarObjeto(2);
            com.enviarObjeto(x);
            com.enviarObjeto(y);
            double res = (Double)com.receberObjeto();
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
            com.enviarObjeto(3);
            com.enviarObjeto(x);
            com.enviarObjeto(y);
            double res = (Double)com.receberObjeto();
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
            com.enviarObjeto(4);
            com.enviarObjeto(x);
            com.enviarObjeto(y);
            double res = (Double)com.receberObjeto();
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    @Override
    public Double[][] multiplicacaoMatriz(Double[][] a, Double[][] b) throws ExcecaoCalculadora {
        try{
            com.enviarObjeto(5);
            com.enviarObjeto(a);
            com.enviarObjeto(b);
            Double[][] res = (Double[][])com.receberObjeto();
            return res;
        }catch(ExcecaoConexao ex){
            throw new ExcecaoCalculadora("Erro ao conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ExcecaoCalculadora("Erro ao receber o objeto: " + ex.getMessage());
        }
    }

    @Override
    public RaizesBhaskara bhaskara(double a, double b, double c) throws ExcecaoCalculadora {
        try{
            com.enviarObjeto(6);
            com.enviarObjeto(a);
            com.enviarObjeto(b);
            com.enviarObjeto(c);
            RaizesBhaskara res = (RaizesBhaskara)com.receberObjeto();
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
