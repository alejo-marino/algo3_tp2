package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Tablero tablero;
    private Continente asia;
    private Continente americaDelSur;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        this.jugador3 = new Jugador("ff0000");

        this.argentina = new Pais("Argentina",jugador1);
        this.uruguay = new Pais("Uruguay",jugador2);
        this.china = new Pais("China",jugador3);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);

        this.americaDelSur = new Continente("America Del Sur", 3);
        this.asia = new Continente("Asia", 6);
        this.americaDelSur.agregarPais(argentina);
        this.americaDelSur.agregarPais(uruguay);
        this.asia.agregarPais(china);

        ArrayList<Continente> continentes = new ArrayList<>();
        continentes.add(americaDelSur);
        continentes.add(asia);

        this.tablero = new Tablero(paises, continentes);
    }

    @Test
    public void test01SeCreaUnTableroYNoEsNull (){
        assertNotNull(tablero);
    }

    @Test
    public void test02SeCreaUnTableroYPuedoSeleccionarUnPais () {
        assertEquals(argentina, tablero.seleccionarPais("Argentina"));
    }

    @Test
    public void test03SeCreaUnTableroYNoPuedoSeleccionarUnPaisInexistente () {
        assertThrows(PaisInexistenteException.class, () -> tablero.seleccionarPais("Chile"));
    }

    @Test
    public void test04SeCreaUnTableroYObtengoLosPaisesPorJugadorCorrectamente() {
        Dictionary<String, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        boolean paisesCorrectosSegunJugador = true;
        Enumeration enumeration = paisesPorJugador.elements();
        while (enumeration.hasMoreElements()){
            ArrayList<Pais> listaPaises = (ArrayList<Pais>) enumeration.nextElement();
            if (listaPaises.size() !=  1) {
                paisesCorrectosSegunJugador = false;
            }
        }

        assertTrue(paisesCorrectosSegunJugador);
    }

}
