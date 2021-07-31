package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestFaseDeJuego {

    private FaseDeJuego faseDeJuego;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<String> tarjetas;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Pais chile;
    private Juego juegoMock;
    private Tarjeta tarjeta1;
    private Tarjeta tarjeta2;
    private Tarjeta tarjeta3;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000", "Jugador 1");
        this.jugador2 = new Jugador("ffffff", "Jugador 2");
        Jugador jugador3 = new Jugador("fff000", "Jugador 3");

        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador1);
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        china = new Pais("China");
        china.asignarDuenio(jugador3);
        chile = new Pais("Chile");
        chile.asignarDuenio(jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);

        this.tarjeta1 = new Tarjeta(argentina, "Globo");
        this.tarjeta2 = new Tarjeta(uruguay, "Globo");
        this.tarjeta3 = new Tarjeta(china, "Globo");
        this.tarjetas = new ArrayList<>();
        tarjetas.add(tarjeta1.toString());
        tarjetas.add(tarjeta2.toString());
        tarjetas.add(tarjeta3.toString());
        tarjeta1.darA(jugador1);
        tarjeta2.darA(jugador1);
        tarjeta3.darA(jugador1);


        this.juegoMock = mock(Juego.class);

        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.calcularEjercitosDisponibles(jugador1)).thenReturn(10);
        when(juegoMock.obtenerNombreTarjetasDe(jugador1)).thenReturn(tarjetas);
        when(juegoMock.canjearTarjetas(tarjetas, jugador1)).thenReturn(4, 7, 10);

        this.faseDeJuego = new FaseDeJuego(juegoMock);
        faseDeJuego.empezarTurno(jugador1);
    }

    @Test
    void test01CreoUnaFaseDeJuegoYNoEsNull () {
        assertNotNull(faseDeJuego);
    }

//    @Test
//    void test02CreoUnaFaseDeJuegoYSeleccionoCorrectamenteUnPaisLaPrimeraVez () {
//        Pais paisSeleccionado = faseDeJuego.seleccionarPais("Argentina");
//
//        assertEquals("Argentina", paisSeleccionado.toString());
//    }

    @Test
    void test03CreoUnaFaseDeJuegoYSeleccionoUnPaisEnemigoLaPrimeraVezYLanzaUnaExcepcion () {
        assertThrows(SeleccionaPaisAjenoException.class, () -> faseDeJuego.seleccionarPais("Uruguay"));
    }

//    @Test
//    void test04CreoUnaFaseDeJuegoYSeleccionoUnPaisEnemigoLaSegundaVez () {
//        faseDeJuego.seleccionarPais("Argentina");
//        Pais paisDefensor = faseDeJuego.seleccionarPais("Uruguay");
//
//        assertEquals("Uruguay", paisDefensor.toString());
//    }

    @Test
    void test05CreoUnaFaseDeJuegoYSeleccionoUnPaisPropioLaSegundaVezYLanzaUnaExcepcion () {
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(AtaqueAPaisPropioException.class, () -> faseDeJuego.seleccionarPais("Chile"));
    }

    @Test
    void test06CreoUnaFaseDeJuegoYNoPuedoReforzar () {
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(RefuerzoInvalidoException.class, () -> faseDeJuego.reforzar(3));
    }

    @Test
    void test07CreoUnaFaseDeJuegoYNoPuedoCanjearTarjetas () {

        assertThrows(CanjeNoPermitidoException.class, () -> faseDeJuego.canjearTarjetas(null));
    }

    @Test
    void test08CreoUnaFaseDeJuegoYNoPuedoReagruparSinFinalizarAtaque () {
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test09CreoUnaFaseDeJuegoYNoPuedoReagruparSinFinalizarAtaque () {
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test10CreoUnaFaseDeJuegoYPuedoReagruparLuegoDeFinalizarAtaque () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.seleccionarPais("Argentina");
        faseDeJuego.seleccionarPais("Chile");

        faseDeJuego.reagrupar(3);
        faseDeJuego.empezarTurno(jugador2);
        assertEquals(4, chile.getEjercitos());
        assertEquals(1, argentina.getEjercitos());
    }

    @Test
    void test11PasoDeTurnoYNoPuedoElegirUnPaisPropioPorSegundaVez () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(AtaqueAPaisPropioException.class, () -> faseDeJuego.seleccionarPais("Chile"));
    }

    @Test
    void test12PasoDeTurnoYNoPuedoReagrupar () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");
        faseDeJuego.seleccionarPais("Uruguay");

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test13CreoUnaFaseDeJuegoYEstoyEnLaFaseCorrecta () {
        String resultadoEsperado = "Fase de juego";
        String resultado = faseDeJuego.getFaseActual();

        assertEquals(resultadoEsperado, resultado);
    }

//    @Test
//    void test14CreoUnaFaseDeJuegoYPasoDeRondaYPuedoSeleccionarUnPaisPropio () {
//        faseDeJuego.siguienteRonda();
//        faseDeJuego.empezarTurno(jugador1);
//        Pais paisSeleccionado = faseDeJuego.seleccionarPais("Argentina");
//
//        assertEquals(argentina, paisSeleccionado);
//    }

    @Test
    void test15CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoSeleccionarUnPaisAjeno () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        assertThrows(SeleccionaPaisAjenoException.class, () -> faseDeJuego.seleccionarPais("Uruguay"));
    }

    @Test
    void test16CreoUnaFaseDeJuegoYPasoDeRondaYPuedoReforzar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        faseDeJuego.reforzar(5);
        Integer cantidadEjercitosArgentina = argentina.getEjercitos();

        assertEquals(9, cantidadEjercitosArgentina);
    }

    @Test
    void test17CreoUnaFaseDeJuegoYPasoDeRondaYRefuerzoParcialmenteYNoPuedoEmpezarSiguienteTurno () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");
        faseDeJuego.reforzar(5);

        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> faseDeJuego.empezarTurno(jugador2));
    }

    @Test
    void test18CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoReforzarMasEjercitosDeLosQuePuedo () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> faseDeJuego.reforzar(11));
    }

    @Test
    void test19CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoAtacar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(AtaqueInvalidoException.class, () -> faseDeJuego.atacar(2));
    }

    @Test
    void test19CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoReagrupar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(2));
    }

    @Test
    void test20CreoUnaFaseDeJuegoYPasoDeRondaYPuedoCanjearTarjetasYReforzarConMasEjercitos () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.canjearTarjetas(tarjetas);
        faseDeJuego.seleccionarPais("Argentina");
        faseDeJuego.reforzar(14);

        Integer cantidadEjercitosArgentina = argentina.getEjercitos();

        assertEquals(18, cantidadEjercitosArgentina);
    }

    @Test
    void test21CreoUnaFaseDeJuegoYPasoDeRondaDosVecesYNoPuedoReforzar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina");

        assertThrows(RefuerzoInvalidoException.class, () -> faseDeJuego.reforzar(2));
    }

}
