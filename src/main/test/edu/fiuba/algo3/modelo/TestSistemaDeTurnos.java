package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestSistemaDeTurnos {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private ArrayList<String> tarjetas;
    private SistemaDeTurnos sistema;
    private Juego juegoMock;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Pais chile;
    private Pais brasil;


    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000", "Jugador 1");
        this.jugador2 = new Jugador("ffffff", "Jugador 2");
        this.jugador3 = new Jugador("fff000", "Jugador 3");
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);    // Primera Ronda Inicial dejara a cada jugador poner 5 ejercitos en sus paises.
        cola.add(3);    // Segunda Ronda Inicial dejara a cada jugador poner 3 ejercitos en sus paises. Luego de esta Ronda, comenzara la Fase De Juego.

        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador1);
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        china = new Pais("China");
        china.asignarDuenio(jugador3);
        chile = new Pais("Chile");
        chile.asignarDuenio(jugador3);
        brasil = new Pais("Brasil");
        brasil.asignarDuenio(jugador2);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(brasil);
        brasil.hacerLimitrofe(argentina);

        Tarjeta tarjeta1 = new Tarjeta(argentina, "Globo");
        Tarjeta tarjeta2 = new Tarjeta(uruguay, "Canion");
        Tarjeta tarjeta3 = new Tarjeta(china, "Barco");
//        this.jugador1.agregarTarjeta(tarjeta1);
//        this.jugador1.agregarTarjeta(tarjeta2);
//        this.jugador1.agregarTarjeta(tarjeta3);
        this.tarjetas = new ArrayList<>();
        this.tarjetas.add(tarjeta1.toString());
        this.tarjetas.add(tarjeta2.toString());
        this.tarjetas.add(tarjeta3.toString());

        this.juegoMock = mock(Juego.class);
        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Brasil")).thenReturn(brasil);

        this.sistema = new SistemaDeTurnos(listaJugadores, juegoMock, cola);
        this.sistema.empezarTurno();
    }

    private void pasarAFaseDeJuego() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Chile");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(3);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(3);
        sistema.empezarTurno();
        sistema.seleccionarPais("Chile");
        sistema.reforzar(3);
    }


    @Test
    public void test01CreoUnSistemaDeTurnosYNoEsNull() {
        assertNotNull(sistema);
    }

    @Test
    public void test02CreoUnSistemaDeTurnosYComienzaElJugadorCorrecto() {
        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test03CreoUnSistemaDeTurnosYJugadorNoPuedeSeleccionarUnPaisAjeno() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> sistema.seleccionarPais("Uruguay"));
    }

//    @Test
//    public void test04CreoUnSistemaDeTurnosYJugadorPuedeSeleccionarUnPaisPropio() {
//        assertDoesNotThrow(RuntimeException.class, () -> sistema.seleccionarPais("Argentina"));
//    }

    @Test
    public void test05CreoUnSistemaDeTurnosYPasoDeTurnoYJugador2NoPuedeSeleccionarPaisDeJugador1() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();

        assertThrows(SeleccionaPaisAjenoException.class, () -> sistema.seleccionarPais("Argentina"));
    }

    @Test
    public void test06CreoUnSistemaDeTurnosYCambiaElTurnoCorrectamente() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();

        assertEquals(jugador2, sistema.turnoDe());
    }

    @Test
    public void test07CreoUnSistemaDeTurnosYHagoUnaRondaCompletaYVuelveAlPrimerJugador() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("China");
        sistema.reforzar(5);
        sistema.empezarTurno();

        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test08CreoUnSistemaDeTurnosYJugadorColocanCincoEjercitosCorrectamente() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);

        assertEquals(6, argentina.getEjercitos());
    }

    @Test
    public void test09CreoUnSistemaDeTurnosYJugadorNoPuedeColocarMasDeCincoFichas() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(2);
        sistema.seleccionarPais("Argentina");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> sistema.reforzar(4));

    }

    @Test
    public void test10CreoUnSistemaDeTurnosYJugadoresColocanCincoFichasCorrectamente() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("China");
        sistema.reforzar(5);

        int cantidadEjercitosTotales = 0;
        cantidadEjercitosTotales += argentina.getEjercitos();
        cantidadEjercitosTotales += uruguay.getEjercitos();
        cantidadEjercitosTotales += china.getEjercitos();

        assertEquals(18, cantidadEjercitosTotales);
    }

    @Test
    public void test11CreoUnSistemaDeTurnosYJugadoresColocanCincoYDespuesNoPuedenColocarCinco() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("China");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(3);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> sistema.reforzar(5));
    }

    @Test
    public void test12SeColocanTodosLosEjercitosEnLaFaseIncialCorrectamente() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("China");
        sistema.reforzar(5);
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(3);
        sistema.empezarTurno();
        sistema.seleccionarPais("Uruguay");
        sistema.reforzar(3);
        sistema.empezarTurno();
        sistema.seleccionarPais("China");
        sistema.reforzar(3);

        int cantidadEjercitosTotales = 0;
        cantidadEjercitosTotales += argentina.getEjercitos();
        cantidadEjercitosTotales += uruguay.getEjercitos();
        cantidadEjercitosTotales += china.getEjercitos();

        assertEquals(27, cantidadEjercitosTotales);
    }

    @Test
    public void test13SeColocanTodosLosEjercitosEnLaFaseIncialCorrectamenteYComienzaLaFaseDeJuego() {
        this.pasarAFaseDeJuego();
        sistema.empezarTurno();

        assertEquals("Fase de juego", sistema.getFaseActual());
    }

    @Test
    public void test14CreoUnSistemaDeTurnosYJugadorNoPuedeColocarMenosDeCincoEjercitos() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(2);

        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> sistema.empezarTurno());
    }

    @Test
    public void test15CreoUnSistemaDeTurnosYNoPuedoAtacar() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(2);

        assertThrows(AtaqueInvalidoException.class, () -> sistema.atacar(1));
    }

    @Test
    public void test16CreoUnSistemaDeTurnosYNoPuedoReagrupar() {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(2);

        assertThrows(ReagrupeInvalidoException.class, () -> sistema.reagrupar(3));
    }

    @Test
    public void test17CreoUnSistemaDeTurnosYElJugador1EmpiezaSinTarjetas () {
        assertEquals(0, sistema.obtenerNombreTarjetas().size());
    }

    @Test
    public void test18PasoDeTurnoYNoPuedoObtenerLasTarjetasDelJugador1 () {
        sistema.seleccionarPais("Argentina");
        sistema.reforzar(5);
        sistema.empezarTurno();
        assertNotEquals(tarjetas, sistema.obtenerNombreTarjetas());
    }

    @Test
    public void test19NoPuedoCanjearTarjetasEnRondaDeAtaqueYReagrupe () {
        this.pasarAFaseDeJuego();
        sistema.empezarTurno();

        assertThrows(CanjeNoPermitidoException.class, () -> sistema.canjearTarjetas(tarjetas));
    }

    @Test
    public void test20Jugador1CompletaMisionComunYGana () {
        jugador1.agregarMision(new MisionComun(jugador1, juegoMock, 30));

        this.pasarAFaseDeJuego();
        sistema.empezarTurno();
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(30);
        sistema.seleccionarPais("Argentina");
        sistema.seleccionarPais("Uruguay");

        assertThrows(JugadorGanoException.class, () -> sistema.atacar(3));
    }

    @Test
    public void test20Jugador1AtacaYJugador2PierdeYEnSiguienteRondaNoEstaElJugador2 () {
        this.pasarAFaseDeJuego();
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.seleccionarPais("Uruguay");
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(3);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(0);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador3)).thenReturn(4);
        sistema.atacar(3);
        sistema.terminarAtaque();
        sistema.empezarTurno();

        assertEquals(jugador3, sistema.turnoDe());
    }

    @Test
    public void test21Jugador1AtacaYJugador3PierdeYEnSiguienteRondaNoEstaElJugador3 () {
        this.pasarAFaseDeJuego();
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.seleccionarPais("Uruguay");
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(3);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(3);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador3)).thenReturn(0);
        sistema.atacar(3);
        sistema.terminarAtaque();
        sistema.empezarTurno();
        sistema.terminarAtaque();
        sistema.empezarTurno();

        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test22Jugador1AtacaYDestruyeAJugador2YJugador3NoCompletaSuMision () {
        jugador3.agregarMision(new MisionDestruccion(juegoMock, jugador2));

        this.pasarAFaseDeJuego();
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.seleccionarPais("Uruguay");
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(3);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(0);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador3)).thenReturn(4);
        // Jugador 1 destruye al jugador 2
        sistema.atacar(3);
        sistema.terminarAtaque();

        // Empieza turno jugador 3
        sistema.empezarTurno();
        sistema.seleccionarPais("Chile");
        sistema.seleccionarPais("Argentina");
        sistema.atacar(3);

        // Si llega a este punto de la ejecucion, el jugador 3 no ganó
        assertTrue(true);
    }

    @Test
    public void test23Jugador1AtacaYDestruyeAJugador2YJugador3NoCompletaSuMision () {
        jugador1.agregarMision(new MisionDestruccion(juegoMock, jugador2));

        this.pasarAFaseDeJuego();
        sistema.empezarTurno();
        sistema.seleccionarPais("Argentina");
        sistema.seleccionarPais("Uruguay");
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(3);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(0);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador3)).thenReturn(4);
        assertThrows(JugadorGanoException.class, () -> sistema.atacar(3));
    }

}