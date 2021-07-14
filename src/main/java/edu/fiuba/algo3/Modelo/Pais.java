package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.excepciones.ReforzarPaisAjenoError;

import java.util.ArrayList;

public class Pais {

    private String paisOcupadoPor;
    private int numeroEjercitos;
    private ArrayList<String> paisesLimitrofes;

    public Pais(String paisOcupadoPor, ArrayList<String> paisesLimitrofes) {
        this.paisesLimitrofes = paisesLimitrofes;
        this.paisOcupadoPor = paisOcupadoPor;
        this.numeroEjercitos = 1;
    }

    public int cantidadEjercitos() {
        return numeroEjercitos;
    }

    public String getPaisOcupadoPor() {
        return paisOcupadoPor;
    }

    public void agrupar(String jugador, int cantidadTropas) {
        if (jugador != paisOcupadoPor) {
            throw new ReforzarPaisAjenoError("Este pais no te pertenece");
        }
        this.numeroEjercitos += cantidadTropas;
    }
}
