package com.ipl.aula6bancodedadosroom.data;

import android.content.Context;

// TODO: 20/04/2022 Adicionar anotação de database com parametros de entities, exportar schema e versão
public abstract class AppDatabase {

    private static AppDatabase database = null;

    public abstract UsuarioDao usuarioDao();

    public static AppDatabase getInstance(Context context) {
        if (database == null) {
            // TODO: 20/04/2022 adicionar configuração incial do Room
        }

        return database;
    }

}
