package com.ipl.aula6bancodedadosroom;

import static com.ipl.aula6bancodedadosroom.data.Converter.converteLocalDateParaLong;
import static com.ipl.aula6bancodedadosroom.data.Converter.converteLongParaLocalDate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula6bancodedadosroom.adapter.ListaUsuarioAdapter;
import com.ipl.aula6bancodedadosroom.databinding.ActivityMainBinding;
import com.ipl.aula6bancodedadosroom.model.UsuarioEntity;
import com.ipl.aula6bancodedadosroom.telas.AdicionarUsuarioActivity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListaUsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupRecyclerView();
        setupOnclickListener();
        carregarUsuariosDoBancoDeDados();
    }

    private void setupRecyclerView() {
        adapter = new ListaUsuarioAdapter(usuarioParaDeletar -> {
            Log.d("IPL1", "setupRecyclerView: " + usuarioParaDeletar);
            // TODO: 20/04/2022 Adicionar AsyncTask para deletar os usuários no banco de dados
            // new AsyncTaskDeletar().execute(usuario)
        });
        binding.listaUsuarios.setAdapter(adapter);
        binding.listaUsuarios.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void setupOnclickListener() {
        binding.botaoAdicionarUsuario.setOnClickListener(view -> {
            Intent intent = new Intent(this, AdicionarUsuarioActivity.class);
            startActivity(intent);
        });
    }

    private void carregarUsuariosDoBancoDeDados() {
        // TODO: 20/04/2022 Adicionar AsyncTask para listar os usuários no banco de dados
        // new AsyncTaskListar().execute(usuario)
        for (int i = 0; i < 5; i++) {
            adapter.addUsuario(new UsuarioEntity("Nome "+i, "Profissão "+i, LocalDate.now().minusDays(i), R.drawable.avatar_1));
        }
    }
}