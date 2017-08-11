package com.cursoandroid.examplerecyclerview.legislabrasil;

import android.content.Context;
import android.os.Bundle;

import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by -Yago- on 10/08/2017.
 */

public class Presenter implements MVP.PresenterImp {

    private ArrayList<Deputado> mDeputados = new ArrayList<>();
    private MVP.ModelImp model;
    private MVP.ViewImp view;

    public Presenter() {
        model = new Model(this);
    }


    @Override
    public void loadData(Bundle savedInstanceState) {
        model.loadData();
    }

    @Override
    public ArrayList<Deputado> getDeputados() {
        return mDeputados;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void setView(MVP.ViewImp view) {
        this.view = view;
    }
}
