package edu.fiuba.algo3.Modelo.JuegoTests;

import edu.fiuba.algo3.Modelo.Exceptions.NoSePuedeAtacarEnEstaEtapaException;
import edu.fiuba.algo3.Modelo.Juego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void test01SeCreaJuegoConDosJugadoresCorrectamente() {
        /* Prueba el correcto inicializamiento de la clase juego y el comienzo del mismo */
        Juego juegoNuevo = new Juego(new String[]{"Juan", "Ignacio"}, new String[]{"Arg"});

        assertNotNull(juegoNuevo);
    }
    @Test
    public void test02JuegoIniciadoConTresJugadoresTieneEsaCantidadDeJugadores() {
        Juego juegoNuevo = new Juego(new String[]{"Juan", "Ignacio", "Fran"}, new String[]{"Arg"});

        assertEquals(3, juegoNuevo.cantidadJugadores());
    }
    @Test
    public void test03UnaVezCreadoElJuegoYComenzadoLaFaseYaEsElTurnoDeUnJugador(){
        String[] listaJugadores = new String[]{"Juan", "Ignacio", "Fran"};
        String jugadorActual;
        boolean turnoDeJugadorCorrecto = false;

        Juego juegoNuevo = new Juego(listaJugadores, new String[]{"Arg"});

        juegoNuevo.comenzarFaseActual();

        jugadorActual = juegoNuevo.turnoDe();

        for (String jugador: listaJugadores) {
            if(jugador == jugadorActual) {
                turnoDeJugadorCorrecto = true;
            }
        }
        assertTrue(turnoDeJugadorCorrecto);
    }
    @Test
    public void test04SeQuiereAtacarEnEtapaInicialYLanzaNoSePuedeAtacarEnEstaEtapaException(){
        String[] listaJugadores = new String[]{"Juan", "Ignacio", "Fran"};
        Juego juegoNuevo = new Juego(listaJugadores, new String[]{"Arg"});

        juegoNuevo.comenzarFaseActual();

        try {
            juegoNuevo.atacar();
        }catch (NoSePuedeAtacarEnEstaEtapaException e){
            assertEquals("No se puede atacar en etapa inicial.",e.getMessage());
        }
    }
    @Test
    public void test05SeQuiereAtacarEnEtapaColocacionFichasYLanzaNoSePuedeAtacarEnEstaEtapaException(){
        String[] listaJugadores = new String[]{"Juan", "Ignacio", "Fran"};
        Juego juegoNuevo = new Juego(listaJugadores, new String[]{"Arg"});

        juegoNuevo.comenzarFaseActual();
        juegoNuevo.siguienteFase();
        try {
            juegoNuevo.atacar();
        }catch (NoSePuedeAtacarEnEstaEtapaException e){
            assertEquals("No se puede atacar en etapa colocacion fichas.",e.getMessage());
        }
    }
}