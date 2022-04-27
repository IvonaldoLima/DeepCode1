package com.ipl.professorallocation.data.repositorio;

import com.ipl.professorallocation.data.service.CursoService;
import com.ipl.professorallocation.data.service.DepartamentoService;
import com.ipl.professorallocation.data.service.ProfessorService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String URL_BASE = "https://professor-allocation.herokuapp.com";

    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ProfessorService getProfessorService() {
        if (retrofit == null) {
            getInstance();
        }
        return retrofit.create(ProfessorService.class);
    }

    public static CursoService getCursoService() {
        if (retrofit == null) {
            getInstance();
        }
        return retrofit.create(CursoService.class);
    }

    public static DepartamentoService getDepartamentoService() {
        if (retrofit == null) {
            getInstance();
        }
        return retrofit.create(DepartamentoService.class);
    }
}
