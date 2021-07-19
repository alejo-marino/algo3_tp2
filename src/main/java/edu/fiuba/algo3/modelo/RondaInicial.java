package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.Queue;

public class RondaInicial implements TipoDeRonda {

    private Queue<Integer> colaRefuerzo;

    public RondaInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda) {
        colaRefuerzo = colaDeNumerosDeRefuerzoPorRonda;
    }

    public boolean puedeContinuar() {
        return colaRefuerzo.size() != 1;
    }
    public Integer siguienteRonda() {
        return colaRefuerzo.remove();
    }

    public Integer cantidadRefuerzo() {
        return colaRefuerzo.peek();
    }

    public String getRondaActual() {
        return "Colocando " + this.cantidadRefuerzo() + " ejercitos";
    }

    public void atacar() {}

    public void reagrupar() {}

    public void seleccionarPais() {}

    public void reforzar() {}
}
