package edu.fiuba.algo3.Modelo;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {

    private String[] paisesDesocupados;
    private Dictionary<String, Pais> paisesOcupados;

    public Tablero(String[] listaPaises) {
        paisesOcupados = new Hashtable<String, Pais>();
        paisesDesocupados = listaPaises;
    }

    public void iniciarTablero() {
        for (String pais: paisesDesocupados) {
            paisesOcupados.put(pais, new Pais(pais));
        }
    }


}
