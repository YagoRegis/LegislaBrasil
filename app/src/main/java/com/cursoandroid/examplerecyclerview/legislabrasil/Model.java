package com.cursoandroid.examplerecyclerview.legislabrasil;

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
 * Created by -Yago- on 10/08/2017.
 */

public class Model implements MVP.ModelImp {
    private ArrayList<Deputado> mDeputados = null;
    private MVP.PresenterImp presenter;

    public Model(MVP.PresenterImp presenter) {
        this.presenter = presenter;
    }

    @Override
    public ArrayList<Deputado> loadData() {
        CamaraService service = CamaraApi.getInstance().create(CamaraService.class);
        service.deputadosList().enqueue(new Callback<Dados>() {
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

    @Override
    public ArrayList<Deputado> fetchData(Response<Dados> response) {
        Dados dados = response.body();
        return dados.getDados();
    }
}
