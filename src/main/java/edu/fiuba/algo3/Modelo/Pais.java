package edu.fiuba.algo3.Modelo;

public class Pais {

    private String paisOcupadoPor;
    private int numeroEjercitos;

    public Pais(String paisOcupadoPor) {

        this.paisOcupadoPor = paisOcupadoPor;
        this.numeroEjercitos = 1;
    }

    public int cantidadEjercitos() {
        return numeroEjercitos;
    }

}
