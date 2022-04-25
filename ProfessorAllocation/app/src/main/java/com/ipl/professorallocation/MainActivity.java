package com.ipl.professorallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.data.ProfessorRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityMainBinding;
import com.ipl.professorallocation.model.Professor;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ProfessorRepositorio professorRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        professorRepositorio = new ProfessorRepositorio();
        setupOnCardClickListener();
    }

    private void setupOnCardClickListener() {
        binding.cardViewProfessores.setOnClickListener(view -> {
            // EXEMPLO :: chamada metodo listar professor - Mover esta chamada para tela de listar professores.
            professorRepositorio.listarProfessores(new RespositorioCallBack<List<Professor>>() {
                @Override
                public void onResponse(List<Professor> response) {
                    Log.d("IPL1", "onResponse sucesso c: " + response);
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("IPL1", "onResponse erro c: " + t);
                }
            });
        });
        binding.cardViewCursos.setOnClickListener(view -> {
            Log.d("IPL1", "cardViewCursos: ");
        });
        binding.cardViewDepartamento.setOnClickListener(view -> {
            Log.d("IPL1", "cardViewDepartamento: ");
        });
        binding.cardViewAlocacao.setOnClickListener(view -> {
            Log.d("IPL1", "cardViewAlocacao: ");
        });

    }

}