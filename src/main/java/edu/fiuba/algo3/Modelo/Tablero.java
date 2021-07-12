package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
    private Dictionary<Integer, ArrayList<Pais>> listaPaisesOcupados;

    public Tablero() {
        listaPaisesOcupados = new Hashtable<Integer, ArrayList<Pais>>();
    }

    public void iniciarTablero(String[] listaPaises, int cantidadJugadores) {
        iniciarJugadores(cantidadJugadores);
        repartirPaises(listaPaises, cantidadJugadores);
    }

    private void iniciarJugadores(int cantidadJugadores) {
        for (int x = 0; x < cantidadJugadores; x++) {
            listaPaisesOcupados.put(x, new ArrayList<>());
        }
    }

    private void repartirPaises(String[] listaPaises, int cantidadJugadores) {
        int contador = 0;
        for (String pais: listaPaises) {
            int jugador = contador % cantidadJugadores;

            ArrayList<Pais> paisesJugador = listaPaisesOcupados.get(jugador);
            paisesJugador.add(new Pais(pais, jugador));
            listaPaisesOcupados.put(jugador, paisesJugador);
            contador++;
        }
    }

    public int cantidadPaisesOcupados() {
        return listaPaisesOcupados.size();
    }

    public Dictionary<Integer, ArrayList<Pais>> obtenerPaisesOcupados() {
        return listaPaisesOcupados;
    }
}
