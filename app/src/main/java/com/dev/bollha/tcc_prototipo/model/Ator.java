package com.dev.bollha.tcc_prototipo.model;

import java.io.Serializable;

/**
 * Created by bollha on 25/10/17.
 */

public class Ator implements Serializable {
    private Long id;
    private int tipoAtor;
    private int sexo; //0 = Masculino 1 = Mulher
    private String nacionalidade;
    private int idade;
    private String nome;
    private String documento;
    private int gravidade;//0 = Normal, 1 = Parcial, 2 = Fatal
    private Long idRegistro;


}
