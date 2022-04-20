package com.ipl.aula6_configuracaoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ipl.aula6_configuracaoroom.data.AppDatabase;
import com.ipl.aula6_configuracaoroom.data.AsyncTaskListarUsuarios;
import com.ipl.aula6_configuracaoroom.model.UsuarioEntity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = AppDatabase.getInstance(this);

        new AsyncTaskListarUsuarios(database, listUsuarios -> {
            listUsuarios.forEach(usuarioEntity -> {
                Log.d("IPL1", "MainActivity usuario: " + usuarioEntity);
            });
        }).execute();
    }
}