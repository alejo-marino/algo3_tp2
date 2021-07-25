package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestRondaInicial {

    private Jugador jugador1;
    private Jugador jugador2;
    private RondaInicial ronda;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("fff000");

        Pais argentina = new Pais("Argentina", jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais china = new Pais("China", jugador3);
        Pais chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);

        Continente americaDelSur = new Continente("America Del Sur", 3);
        Continente asia = new Continente("Asia", 6);
        americaDelSur.agregarPais(argentina);
        americaDelSur.agregarPais(uruguay);
        americaDelSur.agregarPais(chile);
        asia.agregarPais(china);

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        Juego juegoMock = mock(Juego.class);
        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        this.ronda = new RondaInicial(cola, juegoMock);
        ronda.empezarTurno(jugador1);
    }

    @Test
    void test01CreoUnaRondaInicialYNoEsNull () {
        assertNotNull(ronda);
    }

    @Test
    void test02CreoUnaRondaInicialYPuedoSeleccionarUnPaisPropio () {
        Pais paisSeleccionado = ronda.seleccionarPais("Argentina");

        assertEquals("Argentina", paisSeleccionado.toString());
    }

    @Test
    void test03CreoUnaRondaInicialYNoPuedoSeleccionarUnPaisAjeno () {
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay"));
    }

    @Test
    void test04CreoUnaRondaInicialYPuedoReforzarConCincoEjercitos () {
        Pais paisSeleccionado = ronda.seleccionarPais("Argentina");
        int cantidadEjercitosEsperado = 6;

        ronda.reforzar(5);

        assertEquals(cantidadEjercitosEsperado, paisSeleccionado.getEjercitos());
    }

    @Test
    void test05CreoUnaRondaInicialYNoPuedoReforzarConSeisEjercitos () {
        ronda.seleccionarPais("Argentina");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> ronda.reforzar(6));
    }

    @Test
    void test06CreoUnaRondaInicialYNoPuedoPasarDeTurnoSinReforzarTodosLosEjercitos () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(3);

        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> ronda.empezarTurno(jugador2));
    }

    @Test
    void test07CreoUnaRondaInicialYPuedoReforzarDosPaisesPropios () {
        Pais argentina = ronda.seleccionarPais("Argentina");
        ronda.reforzar(3);
        Pais chile = ronda.seleccionarPais("Chile");
        ronda.reforzar(2);
        int cantidadEjercitosEsperadoArgentina = 4;
        int cantidadEjercitosEsperadoChile = 3;

        assertEquals(cantidadEjercitosEsperadoArgentina, argentina.getEjercitos());
        assertEquals(cantidadEjercitosEsperadoChile, chile.getEjercitos());
    }

    @Test
    void test08CreoUnaRondaInicialYPasoDeTurnoYNoPuedoReforzarPaisDeJugadorAnterior () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.empezarTurno(jugador2);

        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Argentina"));
    }

    @Test
    void test09CreoUnaRondaInicialYNoPuedoPasarDeRondaSinReforzarTodosLosEjercitosDisponibles () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(3);

        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> ronda.siguienteRonda());
    }

    @Test
    void test10CreoUnaRondaInicialYPasoDeRondaYNoPuedoReforzarConCincoEjercitos () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> ronda.reforzar(5));
    }

    @Test
    void test11CreoUnaRondaInicialYPasoDeRondaYNoPuedoReforzarConCuatroEjercitos () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> ronda.reforzar(4));
    }

    @Test
    void test12CreoUnaRondaInicialYPasoDeRondaYPuedoReforzarConTresEjercitos () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        Pais paisSeleccionado = ronda.seleccionarPais("Argentina");
        ronda.reforzar(3);
        int cantidadEjercitosEsperado = 9;

        assertEquals(cantidadEjercitosEsperado, paisSeleccionado.getEjercitos());
    }

    @Test
    void test13CreoUnaRondaInicialYPasoDeRondaYPuedoReforzarConTresEjercitosEnDosPaisesPropios () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        Pais argentina = ronda.seleccionarPais("Argentina");
        ronda.reforzar(2);
        Pais chile = ronda.seleccionarPais("Chile");
        ronda.reforzar(1);
        int cantidadEjercitosEsperadoArgentina = 8;
        int cantidadEjercitosEsperadoChile = 2;

        assertEquals(cantidadEjercitosEsperadoArgentina, argentina.getEjercitos());
        assertEquals(cantidadEjercitosEsperadoChile, chile.getEjercitos());
    }

    @Test
    void test14CreoUnaRondaInicialYPasoDeRondaYNoPuedoReforzarConCuatroEjercitosEnDosPaisesPropios () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(2);
        ronda.seleccionarPais("Chile");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> ronda.reforzar(2));
    }

    @Test
    void test15CreoUnaRondaInicialYNoPuedoAtacar () {
        ronda.seleccionarPais("Argentina");

        assertThrows(AtaqueInvalidoException.class, () -> ronda.atacar(3));
    }

    @Test
    void test16CreoUnaRondaInicialYPasoDeRondaYNoPuedoAtacar () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);

        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(AtaqueInvalidoException.class, () -> ronda.atacar(3));
    }

    @Test
    void test17CreoUnaRondaInicialYNoPuedoReagrupar () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);
        ronda.seleccionarPais("Argentina");

        assertThrows(ReagrupeInvalidoException.class, () -> ronda.reagrupar(3));
    }

    @Test
    void test18CreoUnaRondaInicialYPasoDeRondaYNoPuedoReagrupar () {
        ronda.seleccionarPais("Argentina");
        ronda.reforzar(5);
        ronda.siguienteRonda();
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(ReagrupeInvalidoException.class, () -> ronda.reagrupar(3));
    }

}
