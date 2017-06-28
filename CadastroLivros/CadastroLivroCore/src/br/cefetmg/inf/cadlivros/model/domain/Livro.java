package br.cefetmg.inf.cadlivros.model.domain;

import java.util.Date;

public class Livro {
    private String nome;
    private String autor;
    private Long isbn;
    private Integer volume;
    private Date data;
    private String editora;
    private Integer numPaginas;

    public Livro() {
    }

    public Livro(String nome, String autor, Long isbn, Integer volume, Date data, String editora, Integer numPaginas) {
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.volume = volume;
        this.data = data;
        this.editora = editora;
        this.numPaginas = numPaginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }
    
}
