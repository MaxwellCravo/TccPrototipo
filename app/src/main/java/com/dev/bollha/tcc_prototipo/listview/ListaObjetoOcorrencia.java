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
import com.dev.bollha.tcc_prototipo.adapter.ObjetoOcorrenciaAdapter;
import com.dev.bollha.tcc_prototipo.control.AtorControl;
import com.dev.bollha.tcc_prototipo.dao.AtorDao;
import com.dev.bollha.tcc_prototipo.dao.ObjetoDao;
import com.dev.bollha.tcc_prototipo.dao.RegistroAcidenteDao;
import com.dev.bollha.tcc_prototipo.model.Ator;
import com.dev.bollha.tcc_prototipo.model.Objeto;

import java.util.List;

public class ListaObjetoOcorrencia extends AppCompatActivity {
    List<Objeto> objsObjeto;
    List<Ator> objsAtor;
    ObjetoOcorrenciaAdapter adapter;
    ListView mListaObjs;
    private ObjetoDao mDao;
    private AtorDao mDaoAtor;
    int iDOcorrencia;
    private RegistroAcidenteDao mDaoAcidente;
    Button mBtnAdd, mBtnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objeto_ocorrencia);
        //Instanciando o AtorDao para preencher preencher o adapter
        mDao = new ObjetoDao(this);
        mDaoAtor = new AtorDao(this);
        //Coletando os botões do layout
        mBtnAdd = (Button) findViewById(R.id.btnControlAtor);
        mBtnVoltar = (Button) findViewById(R.id.btnVoltar);
        //Coletando a lista do layout
        mListaObjs = (ListView) findViewById(R.id.listAtor);
        //coletando o IdOcorrência da tela anterior
        Intent it = getIntent();
        iDOcorrencia = (int) it.getSerializableExtra("iDOcorrencia");
        //chamando o layout de cadastro
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListaObjetoOcorrencia.this,AtorControl.class);
                intent.putExtra("iDOcorrencia",iDOcorrencia);
                startActivity(intent);
            }
        });
        //Fechando a Tela e voltando para a Principal
        mBtnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        mListaObjs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ator obj = (Ator) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ListaObjetoOcorrencia.this,AtorControl.class);
                intent.putExtra("ator",obj);
                startActivity(intent);
            }
        });
        //deletando o item da ListView
        mListaObjs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Objeto obj = (Objeto) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ListaObjetoOcorrencia.this, AtorControl.class);
                intent.putExtra("ator",obj);
                if(mDao.Excluir(obj)){
                    Toast.makeText(ListaObjetoOcorrencia.this, "Ator Excluido com Sucesso", Toast.LENGTH_LONG).show();
                    AtualizarLista();
                }
                else{
                    Toast.makeText(ListaObjetoOcorrencia.this, "Falha na exclusão =/", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        objsObjeto = mDao.Get(String.valueOf(iDOcorrencia));


        if(objsObjeto.size() == 0){
            Toast.makeText(ListaObjetoOcorrencia.this, "Não há dados cadastrados :(", Toast.LENGTH_LONG).show();
        }else{
            adapter = new ObjetoOcorrenciaAdapter(this, objsObjeto,NomeAtoresdaOcorrência());
            mListaObjs.setAdapter(adapter);
        }
    }
    //coletando todos os nomes de atores envolvidos nesta ocorrência
    public String[] NomeAtoresdaOcorrência(){
        objsAtor = mDaoAtor.Get(""); //(String.valueOf(iDOcorrencia));
        String[] nomeAtorList = new String[objsAtor.size()];
        if(objsAtor.size() == 0) {

            for (int i = 0; i < objsAtor.size(); i++) {
                nomeAtorList[i] = objsAtor.get(i).getNome();
            }
        }
        return nomeAtorList;
    }

    public void AtualizarLista(){
        objsObjeto = mDao.Get(String.valueOf(iDOcorrencia));
        objsAtor = mDaoAtor.Get(""); //(String.valueOf(iDOcorrencia));
        adapter.notifyDataSetChanged();
    }
}
