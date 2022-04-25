package com.ipl.aula7_acessoapi_retrofitconfiguracao.data;

import com.ipl.aula7_acessoapi_retrofitconfiguracao.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProfessorAllocationService {

    @GET("/professors")
    Call<List<Professor>> listaTodosOsProfessores();

    @DELETE("/professors/{id}")
    Call<Void> deletarProfessor(@Path("id") long professorId);
}
