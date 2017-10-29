package com.dev.bollha.tcc_prototipo.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.bollha.tcc_prototipo.R;
import com.dev.bollha.tcc_prototipo.adapter.AtorAdapter;
import com.dev.bollha.tcc_prototipo.control.AtorControl;
import com.dev.bollha.tcc_prototipo.dao.AtorDao;
import com.dev.bollha.tcc_prototipo.dao.RegistroAcidenteDao;
import com.dev.bollha.tcc_prototipo.model.Ator;

import java.util.List;

public class ListaAtor extends AppCompatActivity {

    List<Ator> objs;
    AtorAdapter adapter;
    ListView mListaObjs;
    private AtorDao mDao;
    Long iDOcorrencia;
    private RegistroAcidenteDao mDaoAcidente;
    Button mBtnAdd, mBtnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ator);
        //Instanciando o AtorDao para preencher preencher o adapter
        mDao = new AtorDao(this);
        //Coletando os botões do layout
        mBtnAdd = (Button) findViewById(R.id.btnControlAtor);
        mBtnVoltar = (Button) findViewById(R.id.btnVoltar);
        //Coletando a lista do layout
        mListaObjs = (ListView) findViewById(R.id.listAtor);

        //chamando o layout de cadastro
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListaAtor.this,AtorControl.class);
                startActivity(intent);
            }
        });
        //Fechando a Tela e voltando para a Principal
        mBtnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              finish();
            }
        });

        Intent it = getIntent();
        iDOcorrencia = (Long) it.getSerializableExtra("iDOcorrencia");
        mListaObjs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ator obj = (Ator) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ListaAtor.this,AtorControl.class);
                intent.putExtra("cliente",obj);
                startActivity(intent);
            }
        });
        //deletando o item da ListView
        mListaObjs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ator obj = (Ator) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ListaAtor.this, AtorControl.class);
                intent.putExtra("cliente",obj);
                if(mDao.Excluir(obj)){
                    Toast.makeText(ListaAtor.this, "Cliente Excluido com Sucesso", Toast.LENGTH_LONG).show();
                    AtualizarLista();
                }
                else{
                    Toast.makeText(ListaAtor.this, "Falha na exclusão =/", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        objs = mDao.Get(String.valueOf(iDOcorrencia));

        if(objs.size() == 0){
            Toast.makeText(ListaAtor.this, "Não há dados cadastrados :(", Toast.LENGTH_LONG).show();
        }else{
            adapter = new AtorAdapter(this, objs);
            mListaObjs.setAdapter(adapter);
        }
    }

    public void AtualizarLista(){
        objs = mDao.Get(String.valueOf(iDOcorrencia));
        adapter.notifyDataSetChanged();
    }
}
