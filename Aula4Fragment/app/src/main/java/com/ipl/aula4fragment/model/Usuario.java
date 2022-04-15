package com.ipl.aula4fragment.model;

public class Usuario {
    private String nome;
    private int idImagem;

    public Usuario(String nome, int idImagem) {
        this.nome = nome;
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }
}
