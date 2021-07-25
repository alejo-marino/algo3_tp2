package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestFaseDeJuego {

    private Juego juegoMock;
    private FaseDeJuego faseDeJuego;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Pais chile;

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

        
        this.juegoMock = mock(Juego.class);
        this.juegoMock.setearCantidadJugadores(3);
        this.juegoMock.iniciarJuego();

        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.calcularEjercitosDisponibles(jugador1)).thenReturn(10);

        this.faseDeJuego = new FaseDeJuego(juegoMock);
        faseDeJuego.empezarTurno(jugador1);
    }

    @Test
    void test01CreoUnaFaseDeJuegoYNoEsNull () {
        assertNotNull(faseDeJuego);
    }

    @Test
    void test02CreoUnaFaseDeJuegoYSeleccionoCorrectamenteUnPaisLaPrimeraVez () {
        Pais paisSeleccionado = faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertEquals(argentina, paisSeleccionado);
    }

    @Test
    void test03CreoUnaFaseDeJuegoYSeleccionoUnPaisEnemigoLaPrimeraVezYLanzaUnaExcepcion () {
        assertThrows(SeleccionaPaisAjenoException.class, () -> faseDeJuego.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    void test04CreoUnaFaseDeJuegoYSeleccionoUnPaisEnemigoLaSegundaVez () {
        faseDeJuego.seleccionarPais("Argentina", jugador1);
        Pais paisDefensor = faseDeJuego.seleccionarPais("Uruguay", jugador1);

        assertEquals(uruguay, paisDefensor);
    }

    @Test
    void test05CreoUnaFaseDeJuegoYSeleccionoUnPaisPropioLaSegundaVezYLanzaUnaExcepcion () {
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(AtaqueAPaisPropioException.class, () -> faseDeJuego.seleccionarPais("Chile", jugador1));
    }

    @Test
    void test06CreoUnaFaseDeJuegoYNoPuedoReforzar () {
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(RefuerzoInvalidoException.class, () -> faseDeJuego.reforzar(3));
    }

    @Test
    void test07CreoUnaFaseDeJuegoYNoPuedoCanjearTarjetas () {
        Tarjeta tarjeta1 = new Tarjeta(argentina, "Globo");
        Tarjeta tarjeta2 = new Tarjeta(chile, "Globo");
        Tarjeta tarjeta3 = new Tarjeta(china, "Globo");
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);

        assertThrows(CanjeNoPermitidoException.class, () -> faseDeJuego.canjearTarjetas(tarjetas));
    }

    @Test
    void test08CreoUnaFaseDeJuegoYNoPuedoReagruparSinFinalizarAtaque () {
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test09CreoUnaFaseDeJuegoYNoPuedoReagruparSinFinalizarAtaque () {
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test10CreoUnaFaseDeJuegoYPuedoReagruparLuegoDeFinalizarAtaque () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);
        faseDeJuego.seleccionarPais("Chile", jugador1);

        faseDeJuego.reagrupar(3);

        assertEquals(4, chile.getEjercitos());
        assertEquals(1, argentina.getEjercitos());
    }

    @Test
    void test11PasoDeTurnoYNoPuedoElegirUnPaisPropioPorSegundaVez () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(AtaqueAPaisPropioException.class, () -> faseDeJuego.seleccionarPais("Chile", jugador1));
    }

    @Test
    void test12PasoDeTurnoYNoPuedoReagrupar () {
        faseDeJuego.terminarAtaque(jugador1);
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);
        faseDeJuego.seleccionarPais("Uruguay", jugador1);

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(3));
    }

    @Test
    void test13CreoUnaFaseDeJuegoYEstoyEnLaFaseCorrecta () {
        String resultadoEsperado = "Fase de juego";
        String resultado = faseDeJuego.getFaseActual();

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void test14CreoUnaFaseDeJuegoYPasoDeRondaYPuedoSeleccionarUnPaisPropio () {
        faseDeJuego.siguienteRonda();
        Pais paisEsperado = argentina;
        Pais paisSeleccionado = faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertEquals(paisEsperado, paisSeleccionado);
    }

    @Test
    void test15CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoSeleccionarUnPaisAjeno () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        assertThrows(SeleccionaPaisAjenoException.class, () -> faseDeJuego.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    void test16CreoUnaFaseDeJuegoYPasoDeRondaYPuedoReforzar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        Pais paisSeleccionado = faseDeJuego.seleccionarPais("Argentina", jugador1);

        faseDeJuego.reforzar(5);
        Integer cantidadEjercitosArgentina = argentina.getEjercitos();

        assertEquals(9, cantidadEjercitosArgentina);
    }

    @Test
    void test17CreoUnaFaseDeJuegoYPasoDeRondaYRefuerzoParcialmenteYNoPuedoEmpezarSiguienteTurno () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);
        faseDeJuego.reforzar(5);

        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> faseDeJuego.empezarTurno(jugador2));
    }

    @Test
    void test18CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoReforzarMasEjercitosDeLosQuePuedo () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> faseDeJuego.reforzar(11));
    }

    @Test
    void test19CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoAtacar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(AtaqueInvalidoException.class, () -> faseDeJuego.atacar(2));
    }

    @Test
    void test19CreoUnaFaseDeJuegoYPasoDeRondaYNoPuedoReagrupar () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);
        faseDeJuego.seleccionarPais("Argentina", jugador1);

        assertThrows(ReagrupeInvalidoException.class, () -> faseDeJuego.reagrupar(2));
    }

    @Test
    void test20CreoUnaFaseDeJuegoYPasoDeRondaYPuedoCanjearTarjetasYReforzarConMasEjercitos () {
        faseDeJuego.siguienteRonda();
        faseDeJuego.empezarTurno(jugador1);

        Tarjeta tarjeta1 = new Tarjeta(argentina, "Globo");
        Tarjeta tarjeta2 = new Tarjeta(chile, "Globo");
        Tarjeta tarjeta3 = new Tarjeta(china, "Globo");
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);
        jugador1.agregarTarjeta(tarjeta1);
        jugador1.agregarTarjeta(tarjeta2);
        jugador1.agregarTarjeta(tarjeta3);

        faseDeJuego.canjearTarjetas(tarjetas);
        faseDeJuego.seleccionarPais("Argentina", jugador1);
        faseDeJuego.reforzar(14);

        Integer cantidadEjercitosArgentina = argentina.getEjercitos();

        assertEquals(18, cantidadEjercitosArgentina);
    }

}
