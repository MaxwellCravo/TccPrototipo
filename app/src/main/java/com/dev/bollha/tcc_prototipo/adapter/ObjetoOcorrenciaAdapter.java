package com.dev.bollha.tcc_prototipo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.bollha.tcc_prototipo.R;
import com.dev.bollha.tcc_prototipo.model.Ator;
import com.dev.bollha.tcc_prototipo.model.Objeto;

import java.util.List;

/**
 * Created by bollha on 27/10/17.
 */

public class ObjetoOcorrenciaAdapter extends BaseAdapter {
    Context ctx;
    List<Objeto> objs;
    String[] nomeCondutor;
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

    public ObjetoOcorrenciaAdapter(Context ctx, List<Objeto> objs, String[] nomeCondutor ) {
        this.ctx = ctx;
        this.objs = objs;
        this.nomeCondutor = nomeCondutor;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Objeto obj = objs.get(i);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_ator,null);
        TextView mTxtNome =  linha.findViewById(R.id.txtNome);
        TextView mTxtAno =  linha.findViewById(R.id.txtAno);
        TextView mTxtModelo = linha.findViewById(R.id.txtModelo);
        TextView mTxtPlaca =  linha.findViewById(R.id.txtPlaca);
        TextView mTxtMarca =  linha.findViewById(R.id.txtMarca);


        mTxtNome.setText(nomeCondutor[i]);
        mTxtAno.setText(obj.getAno());
        mTxtModelo.setText(obj.getModelo());
        mTxtPlaca.setText(obj.getPlaca());
        mTxtMarca.setText(obj.getMarca());


        return linha;
    }
}
