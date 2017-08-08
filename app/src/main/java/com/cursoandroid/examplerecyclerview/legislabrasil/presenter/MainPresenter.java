package com.cursoandroid.examplerecyclerview.legislabrasil.presenter;

import android.util.Log;

import com.cursoandroid.examplerecyclerview.legislabrasil.adapter.DeputadoAdapter;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;
import com.cursoandroid.examplerecyclerview.legislabrasil.network.CamaraApi;
import com.cursoandroid.examplerecyclerview.legislabrasil.network.CamaraService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by -Yago- on 06/08/2017.
 */

public class MainPresenter {
    private ArrayList<Deputado> mDeputados;
    private CamaraService service;

    public MainPresenter(ArrayList<Deputado> mDeputados, CamaraService service) {
        this.mDeputados = mDeputados;
        this.service = service;
    }

    public ArrayList<Deputado> getAllDeputados() {
        service = CamaraApi.getInstance().create(CamaraService.class);
        callGetAllDeputados().enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                mDeputados = fetchData(response);
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        return mDeputados;
    }

    private Call<Dados> callGetAllDeputados() {
        return service.deputadosList();
    }

    private ArrayList<Deputado> fetchData(Response<Dados> response) {
        Dados dados = response.body();
        return dados.getDados();
    }

}
