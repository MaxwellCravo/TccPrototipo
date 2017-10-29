package com.dev.bollha.tcc_prototipo.control;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.bollha.tcc_prototipo.R;
import com.dev.bollha.tcc_prototipo.dao.AtorDao;
import com.dev.bollha.tcc_prototipo.model.Ator;

public class AtorControl extends AppCompatActivity {
    private AtorDao mDao;
    private Ator mObj;
    Spinner mSpnGravidade, mSpnNacionalidade, mSpnTipoAtor;
    EditText mEdtIdade,mEdtNome, mEdtDocumento;
    Button mBtnSalvar;
    RadioButton mRdbMas,mRdbFem ;
    Long idOcorrencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ator_control);
        mDao = new AtorDao(this);
        Resources res = this.getResources();
        //botão
        mBtnSalvar = (Button) findViewById(R.id.btnSalvarAtor);
        //Edit text
        mEdtDocumento = (EditText) findViewById(R.id.edtDocumento);
        mEdtNome = (EditText) findViewById(R.id.edtNome);
        mEdtIdade = (EditText) findViewById(R.id.edtIdade);
        //Spinners
        mSpnGravidade = (Spinner) findViewById(R.id.spnGravidade);
        mSpnNacionalidade = (Spinner) findViewById(R.id.spnNacionalidade);
        mSpnTipoAtor = (Spinner) findViewById(R.id.spnTipoAtor);
        //Radio
        mRdbFem = (RadioButton) findViewById(R.id.rdbFem);
        mRdbMas = (RadioButton) findViewById(R.id.rdbMasc);
        FillSpinners();



        Intent it = getIntent();
        mObj = (Ator) it.getSerializableExtra("ator");
        idOcorrencia = (Long) it.getSerializableExtra("iDOcorrencia");
        if(mObj != null) {
            mEdtNome.setText(String.valueOf(mObj.getNome()));
            mEdtDocumento.setText(String.valueOf(mObj.getDocumento()));
            mEdtIdade.setText(String.valueOf(mObj.getIdade()));

            mSpnGravidade.setSelection(mObj.getGravidade());
            mSpnTipoAtor.setSelection(mObj.getTipoAtor());
            mSpnNacionalidade.setSelection(mObj.getNacionalidade());
        }

        mBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = mEdtNome.getText().toString();
                String documento = mEdtDocumento.getText().toString();
                int idade = Integer.parseInt(mEdtIdade.getText().toString());
                int gravidade = mSpnGravidade.getSelectedItemPosition();
                int tipoAtor = mSpnTipoAtor.getSelectedItemPosition();
                int nacionalidade = mSpnNacionalidade.getSelectedItemPosition();
                int toastOption = 0;
//                private Long id;
//                private int tipoAtor;//ciclista, condutor
//                private int sexo; //0 = Masculino 1 = Mulher
//                private int nacionalidade;
//                private int idade;
//                private String nome;
//                private String documento;
//                private int gravidade;//0 = Normal, 1 = Parcial, 2 = Fatal
//                private Long idRegistro;

                Intent it = getIntent();
                mObj = (Ator) it.getSerializableExtra("ator");
                if(mObj == null){
                    //criando um novo onjeto para ser inserido no banco
                    mObj  = new Ator(tipoAtor,Sexo(),nacionalidade,idade,nome,documento,gravidade,idOcorrencia);
                    toastOption = 0;
                }else{
                    //atualizando o item no banco
                    mObj.setTipoAtor(tipoAtor);
                    mObj.setSexo(Sexo());
                    mObj.setNacionalidade(nacionalidade);
                    mObj.setIdade(idade);
                    mObj.setNome(nome);
                    toastOption = 1 ;
                }

                if(mDao.Salvar(mObj)){
                    if(toastOption == 0) {
                        Toast.makeText(AtorControl.this, "Veiculo Cadastrado com Sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(AtorControl.this, "Veiculo Atualizado com Sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }else{
                    Toast.makeText(AtorControl.this, "Algo de errado aconteceu :(", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    public void FillSpinners(){
        String[] combustivel = new String[]{
                "Gasolina","Etanol","Flex"
        };
        ArrayAdapter<String> spinnerAdapterCombustivel = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, combustivel
        );
        spinnerAdapterCombustivel.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        mSpnGravidade.setAdapter(spinnerAdapterCombustivel);

        String[] fabricante = new String[]{
                "VG","GM","Fiat","Ford","Renault",
        };
        // <!--//0=VG 1=GM 2=Fiat 3=Ford 4=Renault -->
        ArrayAdapter<String> spinnerAdapterFabricante = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, fabricante
        );
        spinnerAdapterCombustivel.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        mSpnNacionalidade.setAdapter(spinnerAdapterFabricante);

    }
    public int Sexo(){
        if(mRdbMas.isChecked()){
            return 0;
        }
        else{
            return 1;
        }

    }
}
