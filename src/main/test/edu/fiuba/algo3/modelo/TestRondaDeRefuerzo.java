package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestRondaDeRefuerzo {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Pais chile;
    private RondaDeRefuerzo ronda;
    private Continente americaDelSur;
    private Continente asia;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        this.jugador3 = new Jugador("fff000");
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);

        this.argentina = new Pais("Argentina",jugador1);
        this.uruguay = new Pais("Uruguay",jugador2);
        this.china = new Pais("China",jugador3);
        this.chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        paises.add(chile);

        this.americaDelSur = new Continente("America Del Sur", 3);
        this.asia = new Continente("Asia", 6);
        this.americaDelSur.agregarPais(argentina);
        this.americaDelSur.agregarPais(uruguay);
        this.americaDelSur.agregarPais(chile);
        this.asia.agregarPais(china);

        ArrayList<Continente> continentes = new ArrayList<>();
        continentes.add(americaDelSur);
        continentes.add(asia);

        Tablero tablero = new Tablero(paises, continentes);
        this.ronda = new RondaDeRefuerzo(tablero);
        ronda.empezarTurno(jugador1);
    }

    @Test
    public void test01CreoUnaRondaDeRefuerzoYNoEsNull () {
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeRefuerzoYNoPuedoSeleccionarUnPaisAjeno() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test03CreoUnaRondaDeRefuerzoYPuedoSeleccionarUnPaisPropio() {
        Pais paisSeleccionado = ronda.seleccionarPais("Argentina", jugador1);

        assertEquals(argentina, paisSeleccionado);
    }

    @Test
    public void test04CreoUnaRondaDeRefuerzoYPuedoReforzarUnPaisPropio(){
        Pais paisSeleccionado = ronda.seleccionarPais("Argentina", jugador1);
        ronda.reforzar(2);
        assertEquals(6, paisSeleccionado.getEjercitos());
    }

    @Test
    public void test05CreoUnaRondaDeRefuerzoIntentoSeleccionar2PaisesYLanzaException(){
        ronda.seleccionarPais("Argentina", jugador1);
        assertThrows(PaisesYaSeleccionadosException.class, () -> ronda.seleccionarPais("Chile", jugador1));

    }

}
