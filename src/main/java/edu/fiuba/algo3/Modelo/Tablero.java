package edu.fiuba.algo3.Modelo;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
    private Dictionary<Integer, Pais> listaPaisesOcupados;

    public Tablero() {
        listaPaisesOcupados = new Hashtable<Integer, Pais>();

    }
    public void iniciarTablero(String[] listaPaises, int cantidadJugadores) {
        int contador = 0;
        for (String pais: listaPaises) {
            listaPaisesOcupados.put(contador % cantidadJugadores, new Pais(pais));
            contador++;
        }
    }
    public int cantidadPaisesOcupados() {
        return listaPaisesOcupados.size();
    }
}
