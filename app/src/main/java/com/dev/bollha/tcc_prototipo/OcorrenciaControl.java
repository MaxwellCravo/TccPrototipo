package com.dev.bollha.tcc_prototipo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.dev.bollha.tcc_prototipo.dao.RegistroAcidenteDao;
import com.dev.bollha.tcc_prototipo.model.RegistroAcidente;

public class OcorrenciaControl extends AppCompatActivity {
    Button mBtnSalvarOcorrencia,mBtnObjeto, mBtnAtor, mBtnLocalizacao, mBtnVersaoFato;
    Spinner mSpnZona, mSpnAcidente, mSpnPavimento, mSpnEstadoLocal, mSpnTipoPista, mSpnMaoPista,mSpnVelocidadeVia;
    private RegistroAcidente mObjAcidente;
    private RegistroAcidenteDao mObjAcidenteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencia_control);
        //instanciando o objeto RegistroAcidenteDao
        mObjAcidenteDao = new RegistroAcidenteDao(this);

        //colocando null no objeto mObjAcidente para inserir apenas o Id
        mObjAcidente = null;

        //coletando os botões da Tela
        mBtnSalvarOcorrencia = (Button) findViewById(R.id.btnSalvarOcorrencia);
        mBtnObjeto = (Button) findViewById(R.id.btnObjeto);
        mBtnAtor = (Button) findViewById(R.id.btnAtor);
        mBtnLocalizacao = (Button) findViewById(R.id.btnLocalizacao);
        mBtnVersaoFato = (Button) findViewById(R.id.btnVersaoFato);

        //coletando os Spinners
        mSpnZona = (Spinner) findViewById(R.id.spnZona);
        mSpnAcidente = (Spinner) findViewById(R.id.spnAcidente);
        mSpnPavimento = (Spinner) findViewById(R.id.spnPavimento);
        mSpnEstadoLocal = (Spinner) findViewById(R.id.spnEstadoLocal);
        mSpnTipoPista = (Spinner) findViewById(R.id.spnTipoPista);
        mSpnMaoPista = (Spinner) findViewById(R.id.spnMaoPista);
        mSpnVelocidadeVia = (Spinner) findViewById(R.id.spnVelocidadeVia);


        //inserir uma ocorrência no banco para gerência o ID
        mObjAcidenteDao.Insert(mObjAcidente);
        //Coletando o ID da ocorrencia para enviar para as outras intentes
        final Long iDOcorrencia =  mObjAcidenteDao.GetIdOcorrencia();;

        mBtnSalvarOcorrencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        mBtnObjeto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(OcorrenciaControl.this,ObjetoControl.class);
                intent.putExtra("iDOcorrencia",iDOcorrencia);
                startActivity(intent);

            }
        });
        mBtnAtor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        mBtnLocalizacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
