package com.dev.bollha.tcc_prototipo.model;


import android.graphics.Bitmap;
import android.media.Image;

import java.util.Date;

/**
 * Created by bollha on 25/10/17.
 */

public class RegistroAcidente {
    private Long id;
    private String zonaAcidente;
    private String tipoAcidente;
    private String tipoPavimento;
    private String estadoLocal; //molhado, seco, lama
    private String tipoPista; //Curva, encruzilhada, morro
    private int maoPista;//0=Dupla, 1=única
    private int velocidade; //0=20 1=40 2=60 3=80
    private double latitude;
    private double longitude;
    private Date data;
    private byte[] versaoFato;

    public RegistroAcidente(Long id, String zonaAcidente, String tipoAcidente, String tipoPavimento, String estadoLocal, String tipoPista, int maoPista, int velocidade, double latitude, double longitude, Date data, byte[] versaoFato) {
        this.id = id;
        this.zonaAcidente = zonaAcidente;
        this.tipoAcidente = tipoAcidente;
        this.tipoPavimento = tipoPavimento;
        this.estadoLocal = estadoLocal;
        this.tipoPista = tipoPista;
        this.maoPista = maoPista;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.versaoFato = versaoFato;
    }
    public RegistroAcidente( String zonaAcidente, String tipoAcidente, String tipoPavimento, String estadoLocal, String tipoPista, int maoPista, int velocidade, double latitude, double longitude, Date data, byte[] versaoFato) {
        this.zonaAcidente = zonaAcidente;
        this.tipoAcidente = tipoAcidente;
        this.tipoPavimento = tipoPavimento;
        this.estadoLocal = estadoLocal;
        this.tipoPista = tipoPista;
        this.maoPista = maoPista;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.versaoFato = versaoFato;
    }
    public RegistroAcidente(Long id, String zonaAcidente, String tipoAcidente, String tipoPavimento, String estadoLocal, String tipoPista, int maoPista, int velocidade, double latitude, double longitude) {
        this.id = id;
        this.zonaAcidente = zonaAcidente;
        this.tipoAcidente = tipoAcidente;
        this.tipoPavimento = tipoPavimento;
        this.estadoLocal = estadoLocal;
        this.tipoPista = tipoPista;
        this.maoPista = maoPista;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public RegistroAcidente( String zonaAcidente, String tipoAcidente, String tipoPavimento, String estadoLocal, String tipoPista, int maoPista, int velocidade, double latitude, double longitude, Date data) {
        this.zonaAcidente = zonaAcidente;
        this.tipoAcidente = tipoAcidente;
        this.tipoPavimento = tipoPavimento;
        this.estadoLocal = estadoLocal;
        this.tipoPista = tipoPista;
        this.maoPista = maoPista;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZonaAcidente() {
        return zonaAcidente;
    }

    public void setZonaAcidente(String zonaAcidente) {
        this.zonaAcidente = zonaAcidente;
    }

    public String getTipoAcidente() {
        return tipoAcidente;
    }

    public void setTipoAcidente(String tipoAcidente) {
        this.tipoAcidente = tipoAcidente;
    }

    public String getTipoPavimento() {
        return tipoPavimento;
    }

    public void setTipoPavimento(String tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
    }

    public String getEstadoLocal() {
        return estadoLocal;
    }

    public void setEstadoLocal(String estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(String tipoPista) {
        this.tipoPista = tipoPista;
    }

    public int getMaoPista() {
        return maoPista;
    }

    public void setMaoPista(int maoPista) {
        this.maoPista = maoPista;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public byte[] getVersaoFato() {
        return versaoFato;
    }

    public void setVersaoFato(byte[] versaoFato) {
        this.versaoFato = versaoFato;
    }
}
