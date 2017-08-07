package com.cursoandroid.examplerecyclerview.legislabrasil.network;

import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by -Yago- on 06/08/2017.
 */

public interface CamaraService {
    @Headers("accept: application/json")
    @GET("deputados")
    Call<Dados> deputadosList();
}
