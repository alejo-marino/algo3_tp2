package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;

public class EjercitoNulo extends Ejercito{

    @Override
    public int obtenerCantidadTropasAtaque() {
        throw new EjercitosInsuficientesException("No hay suficientes ejércitos para atacar");
    }

    @Override
    public Ejercito reduccirTropas(int cantidadTropas) {
        return this;
    }
    @Override
    public boolean tengoTropas() {
        return false;
    }
}
