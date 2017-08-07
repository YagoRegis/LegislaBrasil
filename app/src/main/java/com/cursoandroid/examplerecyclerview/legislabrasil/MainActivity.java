package com.cursoandroid.examplerecyclerview.legislabrasil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cursoandroid.examplerecyclerview.legislabrasil.adapter.DeputadoAdapter;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Dados;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;
import com.cursoandroid.examplerecyclerview.legislabrasil.network.CamaraApi;
import com.cursoandroid.examplerecyclerview.legislabrasil.network.CamaraService;
import com.cursoandroid.examplerecyclerview.legislabrasil.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    private MainPresenter mainPresenter;

    private DeputadoAdapter adapter;
    private ArrayList<Deputado> mDeputados;

    private CamaraService service;

    @BindView(R.id.rv_main_activity) RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rvMain.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(layoutManager);

        //loadData();
        mDeputados = mainPresenter.getAllDeputados();

        adapter = new DeputadoAdapter(mDeputados, getApplicationContext());
        rvMain.setAdapter(adapter);
    }

    private void loadData() {
        service = CamaraApi.getInstance().create(CamaraService.class);
        callGetAllDeputados().enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                mDeputados = fetchData(response);
                Log.i("deputados", "deputados");
                adapter = new DeputadoAdapter(mDeputados, getApplicationContext());
                rvMain.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    private Call<Dados> callGetAllDeputados() {
        return service.deputadosList();
    }

    private ArrayList<Deputado> fetchData(Response<Dados> response) {
        Dados dados = response.body();
        return dados.getDados();
    }
}
