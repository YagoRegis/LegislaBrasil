package com.cursoandroid.examplerecyclerview.legislabrasil.models;

/**
 * Created by -Yago- on 06/08/2017.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dados {

    @SerializedName("dados")
    @Expose
    private ArrayList<Deputado> dados = null;

    public ArrayList<Deputado> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Deputado> dados) {
        this.dados = dados;
    }
}
