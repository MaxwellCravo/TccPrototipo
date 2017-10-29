package com.dev.bollha.tcc_prototipo.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.bollha.tcc_prototipo.R;
import com.dev.bollha.tcc_prototipo.model.Ator;

import java.util.List;

/**
 * Created by bollha on 26/10/17.
 */

public class AtorAdapter extends BaseAdapter {
    Context ctx;
    List<Ator> objs;
    @Override
    public int getCount() {
        return objs.size();
    }

    @Override
    public Object getItem(int i) {
        return objs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return objs.get(i).getId();
    }

    public AtorAdapter(Context ctx, List<Ator> objs) {
        this.ctx = ctx;
        this.objs = objs;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Ator obj = objs.get(i);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_ator,null);
        TextView mTxtNome =  linha.findViewById(R.id.txtNome);
        TextView mTxtIdade =  linha.findViewById(R.id.txtIdade);
        TextView mTxtVitima = linha.findViewById(R.id.txtVitima);
        TextView mTxtTipo =  linha.findViewById(R.id.txtTipo);

        switch (obj.getGravidade()){
            case 0:
                mTxtVitima.setText("Vítima - Não");
                break;
            case 1:
                mTxtVitima.setText("Vítima - Parcial");
                break;
            case 2:
                mTxtVitima.setText("Vítima - Fatal");
                break;
        }
        switch (obj.getTipoAtor()){
            case 0:
                mTxtTipo.setText("Caminhoneiro");
                break;
            case 1:
                mTxtTipo.setText("Cilista");
                break;
            case 2:
                mTxtTipo.setText("Condutor");
                break;
            case 3:
                mTxtTipo.setText("Motociclista");
                break;
            case 4:
                mTxtTipo.setText("Passageiro");
                break;
            case 5:
                mTxtTipo.setText("Pedestre");
                break;

        }


        mTxtNome.setText(obj.getNome());
        mTxtIdade.setText(String.valueOf(obj.getIdade())+" Anos");

        return linha;
    }
}
