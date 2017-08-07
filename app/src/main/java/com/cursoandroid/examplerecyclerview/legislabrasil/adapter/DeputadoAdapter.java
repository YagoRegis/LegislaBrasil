package com.cursoandroid.examplerecyclerview.legislabrasil.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroid.examplerecyclerview.legislabrasil.R;
import com.cursoandroid.examplerecyclerview.legislabrasil.models.Deputado;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by -Yago- on 06/08/2017.
 */

public class DeputadoAdapter extends RecyclerView.Adapter<DeputadoAdapter.ViewHolder>{
    private ArrayList<Deputado> mDeputados;
    private Context mContext;

    public DeputadoAdapter(ArrayList<Deputado> deputados, Context context) {
        mDeputados = deputados;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.deputado_foto) ImageView deputadoFoto;
        @BindView(R.id.deputado_name) TextView deputadoName;
        @BindView(R.id.deputado_partido) TextView deputadoPartido;
        @BindView(R.id.deputado_uf) TextView deputadoUf;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public DeputadoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main_activity, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext).load(mDeputados.get(position).getUrlFoto()).fit().centerCrop().into(holder.deputadoFoto);
        holder.deputadoName.setText(mDeputados.get(position).getNome());
        holder.deputadoPartido.setText(mDeputados.get(position).getSiglaPartido());
        holder.deputadoUf.setText(mDeputados.get(position).getSiglaUf());
    }

    @Override
    public int getItemCount() {
        return mDeputados.size();
    }
}
