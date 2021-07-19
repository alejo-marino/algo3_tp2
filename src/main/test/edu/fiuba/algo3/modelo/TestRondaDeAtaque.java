package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisPropioException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestRondaDeAtaque {

    @Test
    public void test01CreoUnaRondaDeAtaqueYNoEsNull() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

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

        RondaDeAtaque ronda = new RondaDeAtaque(tablero);
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeAtaqueYNoPuedoSeleccionarUnPaisAjenoLaPrimeraVez() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

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

        RondaDeAtaque ronda = new RondaDeAtaque(tablero);
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test03CreoUnaRondaDeAtaqueYNoPuedoSeleccionarUnPaisPropioLaSegundaVez() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

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

        RondaDeAtaque ronda = new RondaDeAtaque(tablero);
        Pais paisAtacante = ronda.seleccionarPais("Argentina", jugador1);
        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test04CreoUnaRondaDeAtaqueYNoPuedoReforzar() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

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

        RondaDeAtaque ronda = new RondaDeAtaque(tablero);
        Pais unPais = ronda.seleccionarPais("Argentina", jugador1);

        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }


}
