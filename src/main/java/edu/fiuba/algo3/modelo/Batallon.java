package edu.fiuba.algo3.modelo;

import static edu.fiuba.algo3.modelo.Constantes.*;

public class Batallon {

    private int ejercitos;

    public Batallon() {
        ejercitos = 1;
    }

    public int getEjercitos() {
        return ejercitos;
    }

    public int getEjercitosParaAtacar() {
        if (ejercitos > ejercitosParaAtacarMaximo) {
            return ejercitosParaAtacarMaximo;
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

    public int getEjercitosParaDefender() {
        if (ejercitos > ejercitosParaDefenderMaximo) {
            return ejercitosParaDefenderMaximo;
        }
        return ejercitos;
    }

    public int getEjercitosParaReagruparEnAtaque() {
        if ((ejercitos - 2) > ejercitosParaReagruparEnAtaqueMaximo) {
            return ejercitosParaReagruparEnAtaqueMaximo;
        }
        return ejercitos - 2;
    }
}