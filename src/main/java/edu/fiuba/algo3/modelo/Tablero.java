package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


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


    public Dictionary obtenerPaisesSegunJugador() {
        Hashtable<Jugador, ArrayList<Pais>> paisesSegunJugador = new Hashtable();
        for (Pais paisActual : paises) {
            Jugador jugadorActual = paisActual.getDuenio();
            if (!paisesSegunJugador.containsKey(jugadorActual)) {
                ArrayList paisesDeJugador = new ArrayList();
                paisesDeJugador.add(paisActual);
                paisesSegunJugador.put(jugadorActual,paisesDeJugador);
            }
            else {
                paisesSegunJugador.get(jugadorActual).add(paisActual);
            }
        }
        return paisesSegunJugador;
    }


    public Integer calcularEjercitosDisponibles(Jugador jugador) {
        int ejercitosAAgregar = 0;
        Dictionary paisesPorJugador = this.obtenerPaisesSegunJugador();

        // ejercitos a agregar por paises
        ejercitosAAgregar += (this.numeroPaisesDeJugador(paisesPorJugador, jugador) / 2);
        // ejercitos a agregar por continentes
        for (Continente continente: continentes) {
            ejercitosAAgregar += continente.obtenerBonusDeContinentePara(jugador);
        }
        if (ejercitosAAgregar < 3) { ejercitosAAgregar = 3; }
        return ejercitosAAgregar;
    }


    private Integer numeroPaisesDeJugador(Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador, Jugador jugador) {
        return (paisesPorJugador.get(jugador)).size();
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

}
