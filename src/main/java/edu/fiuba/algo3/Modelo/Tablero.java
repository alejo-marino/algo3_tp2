package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tablero {

    public Dictionary<String,  Pais> listaPaisesOcupados;

    public Tablero() {
        listaPaisesOcupados = new Hashtable<String, Pais>();
    }

    public void iniciarTablero(Dictionary<String, ArrayList<String>> listaPaises,ArrayList<String> listaJugadores) {
        int contador = 0;
        Enumeration enumeration = listaPaises.keys();
        while (enumeration.hasMoreElements()) {
            String pais = (String) enumeration.nextElement();
            ArrayList<String> paisesLimitrofes = listaPaises.get(pais);
            listaPaisesOcupados.put(pais, new Pais(listaJugadores.get(contador % listaJugadores.size()), paisesLimitrofes));
            contador++;
        }
    }

    public int cantidadPaisesOcupados() {
        return listaPaisesOcupados.size();
    }

    public Dictionary<String, Pais> obtenerPaisesOcupados() {
        return listaPaisesOcupados;
    }

    public void agrupar(String pais, String jugador, int cantidadTropas) {
        Pais paisAgrupar = listaPaisesOcupados.get(pais);
        paisAgrupar.agrupar(jugador, cantidadTropas);
    }
}
