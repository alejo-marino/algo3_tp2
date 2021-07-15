package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;

public class Batallon {

    private int ejercitos;
    private Ejercito ejercito;

    public Batallon() {
        ejercito = new EjercitoUnitario();
    }

    public int getEjercitos() {
        return ejercito.getCantidadTropas();
    }

    public int getEjercitosParaAtacar() {
        return ejercito.obtenerCantidadTropasAtaque();
    }

    public void agregarEjercitos(int cantidadEjercitos) {
        ejercito = ejercito.agregarTropas(cantidadEjercitos);
    }

    public boolean tengoEjercitos() {
        return ejercito.tengoTropas();
    }

    public void disminuirEjercitos(int cantidadEjercitos) {
        ejercito = ejercito.reduccirTropas(cantidadEjercitos);
    }
}