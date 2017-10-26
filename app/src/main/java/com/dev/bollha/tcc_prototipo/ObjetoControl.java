package com.dev.bollha.tcc_prototipo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ObjetoControl extends AppCompatActivity {
    private TextView txtTeste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto_control);

        txtTeste = (TextView) findViewById(R.id.txtTeste);
        //recebendo o IdPai da tela Anterior
        Intent it = getIntent();
        Long iDOcorrencia = (Long) it.getSerializableExtra("iDOcorrencia");
        txtTeste.setText(iDOcorrencia.toString());
    }
}
