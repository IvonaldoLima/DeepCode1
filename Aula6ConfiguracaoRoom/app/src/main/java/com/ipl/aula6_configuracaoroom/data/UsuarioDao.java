package com.ipl.aula6_configuracaoroom.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ipl.aula6_configuracaoroom.model.UsuarioEntity;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM usuario")
    List<UsuarioEntity> getTodosOsUsuarios();

    @Insert
    void inserirUsuario(UsuarioEntity usuarioEntity);
}
