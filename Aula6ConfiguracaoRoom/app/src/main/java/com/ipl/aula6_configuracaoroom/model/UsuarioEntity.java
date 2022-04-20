package com.ipl.aula6_configuracaoroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class UsuarioEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "nome_usuario")
    public String nome;

    public UsuarioEntity(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
