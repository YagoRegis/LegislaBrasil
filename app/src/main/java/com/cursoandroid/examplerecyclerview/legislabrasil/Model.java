package com.cursoandroid.examplerecyclerview.legislabrasil;

import android.util.Log;

import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;
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
    private static CamaraService camaraService;

    public Model(MVP.PresenterImp presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        camaraService.getInstance().deputadosList().enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                mDeputados = fetchData(response);

                if(mDeputados != null) {
                    presenter.getDeputados();
                }
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                try {
                    throw new InterruptedException("Erro ao se comunicar com o servidor!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public ArrayList<Deputado> fetchData(Response<Dados> response) {
        Dados dados = response.body();
        return dados.getDados();
    }

}
