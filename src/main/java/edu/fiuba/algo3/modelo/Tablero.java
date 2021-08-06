package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import static edu.fiuba.algo3.modelo.Constantes.ejercitosMinimosTurnoRefuerzo;


public class Tablero {

    private ArrayList<Pais> paises;
    private ArrayList<Continente> continentes;

    public Tablero(ArrayList<Pais> paises, ArrayList<Continente> continentes) {
        this.paises = paises;
        this.continentes = continentes;
    }

    public Pais seleccionarPais(String nombrePais) {
        for (Pais pais: paises) {
            if(pais.toString().equals(nombrePais))
                return pais;
        }
        throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
    }

    public Integer obtenerCantidadPaisesSegunJugador (Jugador jugador) {
        Integer contador = 0;
        for (Pais pais: paises) {
            if (pais.esDuenio(jugador)) {
                contador++;
            }
        }
        return contador;
    }


    public Integer calcularEjercitosDisponibles(Jugador jugador) {
        int ejercitosAAgregar = 0;

        // ejercitos a agregar por paises
        int cantidadPaisesJugador = obtenerCantidadPaisesSegunJugador(jugador);
        ejercitosAAgregar += (cantidadPaisesJugador / 2);
        // ejercitos a agregar por continentes
        for (Continente continente: continentes) {
            ejercitosAAgregar += continente.obtenerBonusDeContinentePara(jugador);
        }
        if (ejercitosAAgregar < ejercitosMinimosTurnoRefuerzo) { ejercitosAAgregar = ejercitosMinimosTurnoRefuerzo; }
        return ejercitosAAgregar;
    }

    private Continente seleccionarContinente(String nombreContinente) {
        for (Continente continente: continentes) {
            if(continente.toString().equals(nombreContinente))
                return continente;
        }
        throw new ContinenteInexistenteException(nombreContinente + " no se encuentra en el tablero.");
    }

    public Integer paisesConquistadosPorEn(Jugador jugador, String nombreContinente) {
        Continente continente = seleccionarContinente(nombreContinente);
        return continente.paisesConquistadosPor(jugador);
    }

    public Integer size() {
        return paises.size();
    }

    public int getEjercitosDe(String nombrePais) {
        Pais pais = seleccionarPais(nombrePais);
        return pais.getEjercitos();
    }

    public String getColor(String nombrePais) {
        Pais pais = seleccionarPais(nombrePais);
        return pais.getColor();
    }
}
