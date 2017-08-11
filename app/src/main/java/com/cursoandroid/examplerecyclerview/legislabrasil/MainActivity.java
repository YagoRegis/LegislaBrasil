package com.cursoandroid.examplerecyclerview.legislabrasil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cursoandroid.examplerecyclerview.legislabrasil.adapter.DeputadoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MVP.ViewImp {
    private RecyclerView.LayoutManager layoutManager;

    private DeputadoAdapter adapter;
    private static MVP.PresenterImp presenter;


    @BindView(R.id.rv_main_activity) RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if(presenter == null) {
            presenter = new Presenter();
        }

        presenter.setView(this);
        presenter.loadData(savedInstanceState);

        //loadData();
    }

    @Override
    protected void onStart() {
        super.onStart();

        rvMain.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(layoutManager);
        
        adapter = new DeputadoAdapter(presenter.getDeputados(), this);
        rvMain.setAdapter(adapter);
    }

    @Override
    public void loadRecyclerView() {
        adapter.notifyDataSetChanged();
    }


    /*
    private void loadData() {
        service = CamaraApi.getInstance().create(CamaraService.class);
        service.deputadosList().enqueue(new Callback<Dados>() {
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
    */
}
