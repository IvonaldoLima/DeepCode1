package com.ipl.aula7_acessoapi_retrofitconfiguracao;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula7_acessoapi_retrofitconfiguracao.adapter.ListaProfessorAdapter;
import com.ipl.aula7_acessoapi_retrofitconfiguracao.data.ProfessorAllocationService;
import com.ipl.aula7_acessoapi_retrofitconfiguracao.data.RetrofitClient;
import com.ipl.aula7_acessoapi_retrofitconfiguracao.databinding.ActivityMainBinding;
import com.ipl.aula7_acessoapi_retrofitconfiguracao.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListaProfessorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listarTodosOsProfessores();
        setupRecyclerView();
        setupOnCLickListener();
    }

    private void setupOnCLickListener() {
        binding.botaoAtualizarListaProfessor.setOnClickListener(view -> {
            listarTodosOsProfessores();
        });
    }

    private void setupRecyclerView() {
        adapter = new ListaProfessorAdapter(deletarProfessor -> {
            deletarProfessor(deletarProfessor);
        });
        binding.listaProfessor.setAdapter(adapter);
        binding.listaProfessor.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void listarTodosOsProfessores() {
        mostrarProgressBar(View.VISIBLE);
        ProfessorAllocationService service = RetrofitClient.getProfessorAllocationService();
        Call<List<Professor>> call = service.listaTodosOsProfessores();
        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                Log.d("IPL1", "onResponse: " + response.body());
                adapter.addListaProfessor(response.body());
                mostrarProgressBar(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                Log.d("IPL1", "onFailure: " + t);
                mostrarProgressBar(View.GONE);
            }
        });
    }

    private void deletarProfessor(Professor professor) {
        mostrarProgressBar(View.VISIBLE);
        ProfessorAllocationService service = RetrofitClient.getProfessorAllocationService();
        Call<Void> call = service.deletarProfessor(professor.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("IPL1", "onResponse delete: " + response.body());
                adapter.removerUsuario(professor);
                mostrarProgressBar(View.GONE);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("IPL1", "onFailure delete: " + t);
                mostrarProgressBar(View.GONE);
            }
        });
    }

    private void mostrarProgressBar(int mostrarProgressBar) {
        binding.progressBar.setVisibility(mostrarProgressBar);
    }

}