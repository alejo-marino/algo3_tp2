package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    private Pais argentina;
    private Pais uruguay;
    private Pais brasil;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private ArrayList<Pais> paises;

    /*
    @BeforeEach
    public void setUp() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais brasil = new Pais("Brasil",jugador3);
        ArrayList<Pais> paises = new ArrayList();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(brasil);
    }
    */
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

    @Test
    public void test04SeCreaUnTableroYObtengoLosPaisesPorJugadorCorrectamente() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);

        Dictionary paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        boolean paisesCorrectosSegunJugador = true;
        Enumeration enumeration = paisesPorJugador.elements();
        while (enumeration.hasMoreElements()){
            ArrayList listaPaises = (ArrayList) enumeration.nextElement();
            if (listaPaises.size() !=  1) {
                paisesCorrectosSegunJugador = false;
            }
        }
        assertTrue(paisesCorrectosSegunJugador);
    }
    /* Refactor Ya No sirven.
    @Test
    public void test07SeCreaUnTableroYRefuerzoUnPaisConUnEjercito() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);

        tablero.reforzarPredeterminado(jugador1,"Argentina", 1);
        assertEquals(argentina.getEjercitos(), 2);
    }

    @Test
    public void test08SeCreaUnTableroYAtacoConUnPaisCon1EjercitoAOtroCon1EjercitoYPierdo() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);

        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(3);

        tablero.reforzarPredeterminado(jugador1,"Argentina", 1);
        tablero.atacarConAPredeterminado(jugador1, "Argentina", "Uruguay", tiradaAtacante, tiradaDefensor);
        assertEquals(1, argentina.getEjercitos() );

    }
    @Test
    public void test09SeCreaUnTableroYAtacoConUnPaisCon1EjercitoAOtroCon1EjercitoYLoConquisto() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);

        Tablero tablero = new Tablero(paises);

        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);

        tablero.reforzarPredeterminado(jugador1,"Argentina", 1);
        tablero.atacarConAPredeterminado(jugador1, "Argentina", "Uruguay", tiradaAtacante, tiradaDefensor);
        assertTrue(argentina.esAliado(uruguay));
    }*/
}
