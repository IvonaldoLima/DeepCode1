package com.ipl.aula4fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ipl.aula4fragment.databinding.ActivityMainBinding;
import com.ipl.aula4fragment.lista_usuarios.ListaUsuarioFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListaUsuarioFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setupView();
        setupOnClickListener();
    }

    private void setupView() {
        fragment = (ListaUsuarioFragment) getSupportFragmentManager().findFragmentById(R.id.lista_usuarios_fragment);
    }

    private void setupOnClickListener() {
        binding.buttonSend.setOnClickListener(view -> {
            String nomeDoUsuario = binding.editTextNomeUsuario.getText().toString();
            fragment.setTexto(nomeDoUsuario);
        });
    }
}