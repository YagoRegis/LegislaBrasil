package com.cursoandroid.examplerecyclerview.legislabrasil.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by -Yago- on 06/08/2017.
 */

public class CamaraApi {
    private static Retrofit retrofit = null;

    public static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static Retrofit getInstance() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();

        return retrofit;
    }
}
