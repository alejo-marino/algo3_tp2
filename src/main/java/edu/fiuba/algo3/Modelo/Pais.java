package edu.fiuba.algo3.Modelo;

public class Pais {
    private String nombrePais;
    private int paisOcupadoPor;
    private int numeroEjercitos;

    public Pais(String nombrePais, int paisOcupadoPor) {
        this.nombrePais = nombrePais;
        this.paisOcupadoPor = paisOcupadoPor;
        this.numeroEjercitos = 1;
    }

    public int cantidadEjercitos() {
        return numeroEjercitos;
    }
}
