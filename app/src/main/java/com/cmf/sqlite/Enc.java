package com.cmf.sqlite;

public class Enc {
    private String codigo;
    private String programa;
    private String computador;
    private String internet;
    private String smartphone;

    public Enc() {
    }

    public Enc(String codigo, String programa, String computador, String internet, String smartphone) {
        this.codigo = codigo;
        this.programa = programa;
        this.computador = computador;
        this.internet = internet;
        this.smartphone = smartphone;
    }

    public String  getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    @Override
    public String toString() {
        return "Enc{" +
                "codigo=" + codigo +
                ", programa='" + programa + '\'' +
                ", computador='" + computador + '\'' +
                ", internet='" + internet + '\'' +
                ", smartphone='" + smartphone + '\'' +
                '}';
    }
}
