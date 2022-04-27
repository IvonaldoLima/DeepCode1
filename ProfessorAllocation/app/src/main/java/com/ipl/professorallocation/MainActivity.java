package com.ipl.professorallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.databinding.ActivityMainBinding;
import com.ipl.professorallocation.view.listar_professor.ListarProfessoresActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupOnCardClickListener();
    }

    private void setupOnCardClickListener() {
        binding.cardViewProfessores.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListarProfessoresActivity.class);
            startActivity(intent);
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