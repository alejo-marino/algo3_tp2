package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;

public class TestSistemaDeTurnos {
        @Test
        public void test01CreoUnSistemaDeTurnosYNoEsNull () {
            Jugador jugador1 = new Jugador("000000");
            Jugador jugador2 = new Jugador("ffffff");
            Jugador jugador3 = new Jugador("ff0000");

            Pais argentina = new Pais("Argentina",jugador1);
            Pais uruguay = new Pais("Uruguay",jugador2);
            Pais china = new Pais("China",jugador3);
            ArrayList<Jugador> listaJugadores = new ArrayList<>();

            listaJugadores.add(jugador1);
            listaJugadores.add(jugador2);
            listaJugadores.add(jugador3);
            ArrayList<Pais> paises = new ArrayList<>();
            paises.add(argentina);
            paises.add(uruguay);
            paises.add(china);
            argentina.hacerLimitrofe(uruguay);
            uruguay.hacerLimitrofe(argentina);
            Tablero tablero = new Tablero(paises);

            SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
            assertNotNull(sistema);
        }
    @Test
    public void test02CreoUnSistemaDeTurnosYComienzaElJugadorCorrecto () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        assertEquals(jugador1, sistema.turnoDe());
    }
    @Test
    public void test03CreoUnSistemaDeTurnosYCambiaElTurnoCorrectamente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        sistema.siguienteTurno();
        assertEquals(jugador2, sistema.turnoDe());
    }
    @Test
    public void test04CreoUnSistemaDeTurnosYHagoUnaRondaCompletaYVuelveAlPrimerJugador () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        sistema.siguienteTurno();
        sistema.siguienteTurno();
        sistema.siguienteTurno();
        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test05CreoUnSistemaDeTurnosYJugadorColocanCincoEjercitosCorrectamente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        sistema.reforzar(argentina, 5);
        assertEquals(6, argentina.getEjercitos());
    }

    @Test
    public void test06CreoUnSistemaDeTurnosYLosJugadoresColocanLosCincoEjercitos () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        sistema.siguienteTurno();
        sistema.siguienteTurno();
        sistema.siguienteTurno();
        assertNotEquals(jugador2, sistema.turnoDe());
    }

    /*@Test
    public void test06CreoUnSistemaDeTurnosYEmpiezaEnFaseInicial () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        assertEquals("Fase inicial", sistema.getFaseActual());
    }*/
}

/*
    Fase inicial
        - Refuerzo de 5
        - Refuerzo de 3
    Fase de Juego
        - Ataque normal
        - Refuerzo normal
        -
 */