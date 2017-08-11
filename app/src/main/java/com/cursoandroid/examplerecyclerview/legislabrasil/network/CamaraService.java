package com.cursoandroid.examplerecyclerview.legislabrasil.network;

import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by -Yago- on 06/08/2017.
 */

public class CamaraService {
    private static String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    public interface CamaraAPI {
        @GET("deputados")
        Call<Dados> deputadosList();
    }

    public static CamaraAPI getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit.create(CamaraAPI.class);
    }
}
