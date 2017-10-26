package com.dev.bollha.tcc_prototipo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnControlOcorrencia, mBtnEnviarDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnControlOcorrencia = (Button) findViewById(R.id.btnControlOcorrencia);

        mBtnControlOcorrencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OcorrenciaControl.class);
                startActivity(intent);
            }
        });
    }
}
