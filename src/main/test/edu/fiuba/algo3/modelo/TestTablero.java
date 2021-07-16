package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    @Test
    public void test01SeCreaUnTableroYNoEsNull (){
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);


        Tablero tablero = new Tablero(paises);
        assertNotNull(tablero);
    }

    @Test
    public void test02SeCreaUnTableroYPuedoSeleccionarUnPais () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);
        assertEquals(argentina, tablero.seleccionarPais("Argentina"));
    }

    @Test
    public void test03SeCreaUnTableroYNoPuedoSeleccionarUnPaisInexistente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);
        assertThrows(PaisInexistenteException.class, () -> tablero.seleccionarPais("Chile"));
    }
}
