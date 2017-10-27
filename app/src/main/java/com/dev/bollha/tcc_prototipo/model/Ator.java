package com.dev.bollha.tcc_prototipo.model;

import java.io.Serializable;

/**
 * Created by bollha on 25/10/17.
 */

public class Ator implements Serializable {
    private Long id;
    private int tipoAtor;//ciclista, condutor
    private int sexo; //0 = Masculino 1 = Mulher
    private int nacionalidade;
    private int idade;
    private String nome;
    private String documento;
    private int gravidade;//0 = Normal, 1 = Parcial, 2 = Fatal
    private Long idRegistro;

    public Ator(Long id, int tipoAtor, int sexo, int nacionalidade, int idade, String nome, String documento, int gravidade, Long idRegistro) {
        this.id = id;
        this.tipoAtor = tipoAtor;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.nome = nome;
        this.documento = documento;
        this.gravidade = gravidade;
        this.idRegistro = idRegistro;
    }
    public Ator(int tipoAtor, int sexo, int nacionalidade, int idade, String nome, String documento, int gravidade, Long idRegistro) {
        this.tipoAtor = tipoAtor;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.nome = nome;
        this.documento = documento;
        this.gravidade = gravidade;
        this.idRegistro = idRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoAtor() {
        return tipoAtor;
    }

    public void setTipoAtor(int tipoAtor) {
        this.tipoAtor = tipoAtor;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(int nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }
}
