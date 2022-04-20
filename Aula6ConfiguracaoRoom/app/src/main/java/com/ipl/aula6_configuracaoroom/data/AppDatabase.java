package com.ipl.aula6_configuracaoroom.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ipl.aula6_configuracaoroom.model.UsuarioEntity;

@Database(entities = {UsuarioEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase database = null;

    public abstract UsuarioDao usuarioDao();

    public static AppDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, AppDatabase.class, "app_teste_room.db")
                    .build();
        }
        return database;
    }
}
