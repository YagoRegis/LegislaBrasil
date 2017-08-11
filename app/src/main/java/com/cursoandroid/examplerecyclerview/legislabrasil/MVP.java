package com.cursoandroid.examplerecyclerview.legislabrasil;

import android.content.Context;
import android.os.Bundle;

import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by -Yago- on 10/08/2017.
 */

public interface MVP {
    interface ModelImp {
        ArrayList<Deputado> loadData();
        ArrayList<Deputado> fetchData(Response<Dados> response);
    }

    interface PresenterImp {
        void loadData(Bundle savedInstanceState);
        ArrayList<Deputado> fetchData(Response<Dados> response);
        ArrayList<Deputado> getDeputados();
        Context getContext();
        void setView(ViewImp view);
    }

    interface ViewImp {
        String DEPUTADOS_KEY = "deputados";
        void loadRecyclerView();
    }
}
