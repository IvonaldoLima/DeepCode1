package com.ipl.aula7_acessoapi_retrofitconfiguracao.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static ProfessorAllocationService professorAllocationService;

    private static final String URL_BASE = "https://professor-allocation.herokuapp.com";

    public static Retrofit getInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ProfessorAllocationService getProfessorAllocationService() {
        if(professorAllocationService == null) {
            professorAllocationService = RetrofitClient.getInstance().create(ProfessorAllocationService.class);
        }
        return professorAllocationService;
    }
}
