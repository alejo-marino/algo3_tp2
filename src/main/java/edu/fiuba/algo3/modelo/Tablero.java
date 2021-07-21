package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisInexistenteException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


public class Tablero {

    private ArrayList<Pais> paises;

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
        Hashtable<Jugador, ArrayList> paisesSegunJugador = new Hashtable();
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

//    public void atacarConA(Pais atacante, Pais defensor) {
//        Combate combate = new Combate(atacante, defensor);
//        combate.combatir(cantidadEjercitos);
//    }
//
//    public void atacarConAPredeterminado(Pais atacante, Pais defensor, ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
//        Combate combate = new Combate(atacante, defensor);
//        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
//    }
//
//    public void reforzar(Pais pais, int cantDeEjercitosAReforzar) {
//        pais.reforzar(cantDeEjercitosAReforzar);
//    }
//
//    public void reforzarPredeterminado(Pais pais, int ejercitos){
//        pais.reforzar(ejercitos);
//    }
}
