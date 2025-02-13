package com.soltelec.reportefur.models.dtos;

public class PruebaInfo {
    private String instrumento;
    private String marca;

    public PruebaInfo(String instrumento, String marca) {
        this.instrumento = instrumento;
        this.marca = marca;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "PruebaInfo{instrumento='" + instrumento + "', marca='" + marca + "'}";
    }
}