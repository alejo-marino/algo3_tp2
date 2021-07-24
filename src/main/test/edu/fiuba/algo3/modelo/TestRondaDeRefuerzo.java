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
    private Juego juegoMock;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        this.jugador3 = new Jugador("fff000");

        this.argentina = new Pais("Argentina",jugador1);
        this.uruguay = new Pais("Uruguay",jugador2);
        this.china = new Pais("China",jugador3);
        this.chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);

        this.americaDelSur = new Continente("America Del Sur", 3);
        this.asia = new Continente("Asia", 6);
        this.americaDelSur.agregarPais(argentina);
        this.americaDelSur.agregarPais(uruguay);
        this.americaDelSur.agregarPais(chile);
        this.asia.agregarPais(china);

        this.juegoMock = mock(Juego.class);
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
