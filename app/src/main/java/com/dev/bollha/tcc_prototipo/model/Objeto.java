package com.dev.bollha.tcc_prototipo.model;

import java.io.Serializable;

/**
 * Created by bollha on 25/10/17.
 */

public class Objeto implements Serializable {
    private Long id;
    private String renavam;
    private String tipoVeiculo;//especie
    private int segurado;//0 = Não 1 = Sim
    private int caracterizado;//0 = Não 1 = Sim
    private int alugado;//0 = Não 1 = Sim
    private Long idCondutor;
    private Long idRegistro;
}
