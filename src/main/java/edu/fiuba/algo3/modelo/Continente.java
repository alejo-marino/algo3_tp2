package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {

    private final String nombre;
    private final ArrayList<Pais> paises;

    public Continente(String nombre) {
        this.nombre = nombre;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais) {
        this.paises.add(pais);
    }

    public boolean esDominadoPor(Jugador jugador) {
        if (paises.size() == 0) {
            return false;
        }
        for (Pais pais: paises) {
            if (pais.getPaisOcupadoPor() != jugador) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
