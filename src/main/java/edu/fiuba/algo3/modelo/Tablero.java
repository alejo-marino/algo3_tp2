package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisInexistenteException;

import java.util.ArrayList;


public class Tablero {

    private ArrayList<Pais> paises;

    public Tablero(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public Pais seleccionarPais(String nombrePais) {
        for (Pais pais: paises) {
            if(pais.toString().equals(nombrePais))
                return pais;
        }
        throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
    }

}
