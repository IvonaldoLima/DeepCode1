package com.ipl.aula6bancodedadosroom.model;

import java.time.LocalDate;

// TODO: 20/04/2022 Adicionar anotação nome da tabela
public class UsuarioEntity {

    // TODO: 20/04/2022 Adicionar anotação PrimaryKey
    // TODO: 20/04/2022 Adicionar anotação nome da coluna
    private String nome;

    // TODO: 20/04/2022 Adicionar anotação nome da coluna
    private String profissao;

    // TODO: 20/04/2022 Adicionar anotação nome da coluna
    private LocalDate dataDeNascimento;

    private int avatarImageId;

    public UsuarioEntity(String nome, String profissao, LocalDate dataDeNascimento, int avatarImageId) {
        this.nome = nome;
        this.profissao = profissao;
        this.dataDeNascimento = dataDeNascimento;
        this.avatarImageId = avatarImageId;
    }

    public int getAvatarImageId() {
        return avatarImageId;
        // TODO: 20/04/2022 Texto t do
    }

    public void setAvatarImageId(int avatarImageId) {
        this.avatarImageId = avatarImageId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
