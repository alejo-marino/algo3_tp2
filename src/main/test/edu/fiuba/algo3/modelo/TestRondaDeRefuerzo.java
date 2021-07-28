package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class TestRondaDeRefuerzo {

    private RondaDeRefuerzo ronda;
    private Pais argentina;

    @BeforeEach
    void setUp() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("fff000");

        this.argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);
        Pais chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);

        Continente americaDelSur = new Continente("America Del Sur", 3);
        Continente asia = new Continente("Asia", 6);
        americaDelSur.agregarPais(argentina);
        americaDelSur.agregarPais(uruguay);
        americaDelSur.agregarPais(chile);
        asia.agregarPais(china);

        Juego juegoMock = mock(Juego.class);
        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        when(juegoMock.calcularEjercitosDisponibles(jugador1)).thenReturn(6);
        this.ronda = new RondaDeRefuerzo(juegoMock);
        ronda.empezarTurno(jugador1);
    }

    @Test
    public void test01CreoUnaRondaDeRefuerzoYNoEsNull () {
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeRefuerzoYNoPuedoSeleccionarUnPaisAjeno() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay"));
    }

//    @Test
//    public void test03CreoUnaRondaDeRefuerzoYPuedoSeleccionarUnPaisPropio() {
//        ronda.seleccionarPais("Argentina");
//
//        assertEquals("Argentina", argentina.toString());
//    }

    @Test
    public void test04CreoUnaRondaDeRefuerzoYPuedoReforzarUnPaisPropio() {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(2);
        assertEquals(6, argentina.getEjercitos());
    }

    @Test
    public void test05CreoUnaRondaDeRefuerzoIntentoSeleccionar2PaisesYLanzaException () {
        ronda.seleccionarPais("Argentina");
        assertThrows(PaisesYaSeleccionadosException.class, () -> ronda.seleccionarPais("Chile"));
    }

}
