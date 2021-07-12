package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tablero {
    private Dictionary<String,  Pais> listaPaisesOcupados;

    public Tablero() {
        listaPaisesOcupados = new Hashtable<String, Pais>();
    }

    public void iniciarTablero(ArrayList<String> listaPaises,ArrayList<String> listaJugadores) {
        int contador = 0;
        for (String pais: listaPaises) {
            listaPaisesOcupados.put(pais, new Pais(listaJugadores.get(contador % listaJugadores.size())));
            contador++;
        }
    }

    public int cantidadPaisesOcupados() {
        return listaPaisesOcupados.size();
    }

    public Dictionary<String, Pais> obtenerPaisesOcupados() {
        return listaPaisesOcupados;
    }
}
