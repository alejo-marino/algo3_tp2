package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;

public class Batallon {

    private int ejercitos;

    public Batallon() {
        ejercitos = 1;
    }

    public int getEjercitos() {
        return ejercitos;
    }

    public int getEjercitosParaAtacar() {
        if (ejercitos - 1 < 1) {
            throw new EjercitosInsuficientesException("No hay suficientes ejércitos para atacar");
        }
        if (ejercitos >= 4) {
            return 3;
        } else {
            return ejercitos - 1;
        }
    }

    public void agregarEjercitos(int cantidadEjercitos) {
        ejercitos = ejercitos + cantidadEjercitos;
    }

    public boolean tengoEjercitos() {
        return ejercitos > 0;
    }

    public void disminuirEjercitos(int cantidadEjercitos) {
        ejercitos = ejercitos - cantidadEjercitos;
        if (ejercitos < 0) {
            ejercitos = 0;
        }
    }
}