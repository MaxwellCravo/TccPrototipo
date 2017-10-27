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

    public Objeto(Long id, String renavam, String tipoVeiculo, int segurado, int caracterizado, int alugado, Long idCondutor, Long idRegistro) {
        this.id = id;
        this.renavam = renavam;
        this.tipoVeiculo = tipoVeiculo;
        this.segurado = segurado;
        this.caracterizado = caracterizado;
        this.alugado = alugado;
        this.idCondutor = idCondutor;
        this.idRegistro = idRegistro;
    }

    public Objeto(String renavam, String tipoVeiculo, int segurado, int caracterizado, int alugado, Long idCondutor, Long idRegistro) {
        this.renavam = renavam;
        this.tipoVeiculo = tipoVeiculo;
        this.segurado = segurado;
        this.caracterizado = caracterizado;
        this.alugado = alugado;
        this.idCondutor = idCondutor;
        this.idRegistro = idRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getSegurado() {
        return segurado;
    }

    public void setSegurado(int segurado) {
        this.segurado = segurado;
    }

    public int getCaracterizado() {
        return caracterizado;
    }

    public void setCaracterizado(int caracterizado) {
        this.caracterizado = caracterizado;
    }

    public int getAlugado() {
        return alugado;
    }

    public void setAlugado(int alugado) {
        this.alugado = alugado;
    }

    public Long getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(Long idCondutor) {
        this.idCondutor = idCondutor;
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }
}
