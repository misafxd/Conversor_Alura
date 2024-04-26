package com.cursoalura.conversor.modelos;

public class Moneda {
    private String monedaBase;
    private String monedaObjetivo;
    private double valorIntercambio;

    public Moneda(Intercambio intercambio){
        this.monedaBase = intercambio.base_code();
        this.monedaObjetivo = intercambio.target_code();
        this.valorIntercambio = intercambio.conversion_rate();
    }
}
