package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CanjeConTarjetaAjenaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestJugador {

    private final Integer NRO_EJERCITOS_PRIMER_CANJE = 4;
    private final Integer NRO_EJERCITOS_SEGUNDO_CANJE = 7;
    private final Integer NRO_EJERCITOS_TERCER_CANJE = 10;

    private Jugador jugador;
    private Jugador otroJugador;
    private Tarjeta tarjetaArgentina;
    private Tarjeta tarjetaUruguay;
    private Tarjeta tarjetaChile;
    private Tarjeta tarjetaBrasil;
    private Tarjeta tarjetaPeru;


    @BeforeEach
    void setUp() {
        this.jugador = new Jugador("000000");
        this.otroJugador = new Jugador("ffffff");

        Pais argentina = new Pais("Argentina", jugador);
        Pais uruguay = new Pais("Uruguay", otroJugador);
        Pais chile = new Pais("Chile", otroJugador);
        Pais brasil = new Pais("Brasil", jugador);
        Pais peru = new Pais("Peru", otroJugador);

        this.tarjetaArgentina = new Tarjeta(argentina, "Globo");
        this.tarjetaUruguay = new Tarjeta(uruguay, "Canion");
        this.tarjetaChile = new Tarjeta(chile, "Barco");
        this.tarjetaBrasil = new Tarjeta(brasil, "Globo");
        this.tarjetaPeru = new Tarjeta(peru, "Globo");
    }

    @Test
    public void test01CreoUnJugadorYNoEsNull () {
       assertNotNull(jugador);
    }

    @Test
    public void test02CreoUnJugadorYTieneElNombreCorrecto () {
        String nombreDelJugador = "000000";
        assertEquals(nombreDelJugador, jugador.toString());
    }

    @Test
    public void test03CreoUnJugadorYAgregoUnaTarjetaCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);

        assertEquals(tarjetas, jugador.getTarjetas());
    }

    @Test
    public void test04CreoUnJugadorYAgregoDosTarjetasCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);

        assertEquals(tarjetas, jugador.getTarjetas());
    }

    @Test
    public void test05AgregoTresTarjetasIgualesYPuedoCanjearCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaBrasil);
        jugador.agregarTarjeta(tarjetaPeru);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaBrasil);
        tarjetas.add(tarjetaPeru);

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test06AgregoTresTarjetasDiferentesYPuedoCanjearCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test07AgregoDosTarjetasIgualesYUnaDiferenteYNoPuedoCanjear () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaBrasil);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaBrasil);

        assertEquals(0, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test08CanjeoYNoPuedoUsarLasMismasTarjetasParaCanjearDeNuevo () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);

        assertThrows(CanjeConTarjetaAjenaException.class, () -> jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test09CanjeoDosVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        assertEquals(NRO_EJERCITOS_SEGUNDO_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test10CanjeoTresVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        assertEquals(NRO_EJERCITOS_TERCER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test11CanjeoCuatroVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        Integer nroDeEjercitosCuartoCanje = 15;
        assertEquals(nroDeEjercitosCuartoCanje, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test12CanjeoVeinteVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);
        for (int i = 0; i < 14; i++) {
            jugador.agregarTarjeta(tarjetaArgentina);
            jugador.agregarTarjeta(tarjetaUruguay);
            jugador.agregarTarjeta(tarjetaChile);
            jugador.canjearTarjetas(tarjetas);
        }
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        Integer nroDeEjercitosCanjeQuince = 70;
        assertEquals(nroDeEjercitosCanjeQuince, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test13AgregoUnaMisionComunYJugadorLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        jugador.agregarMision(misionComun);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(30);

        assertTrue(jugador.gano());
    }

    @Test
    public void test14AgregoUnaMisionComunYJugadorNoLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        jugador.agregarMision(misionComun);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(29);

        assertFalse(jugador.gano());
    }

    @Test
    public void test15AgregoUnaMisionDeDestruccionYJugadorLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(0);

        assertTrue(jugador.gano());
    }

    @Test
    public void test16AgregoUnaMisionDeDestruccionYJugadorNoLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(1);

        assertFalse(jugador.gano());
    }

    @Test
    public void test17AgregoUnaMisionDeConquistaYJugadorLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionConquista);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(4);

        assertTrue(jugador.gano());
    }

    @Test
    public void test18AgregoUnaMisionDeConquistaYJugadorNoLaCompleta () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionConquista);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(3);

        assertFalse(jugador.gano());
    }

    @Test
    public void test19AgregoUnaMisionDeConquistaYUnaComunYJugadorNoCompletaNinguna () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionConquista);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(29);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(3);

        assertFalse(jugador.gano());
    }

    @Test
    public void test20AgregoUnaMisionDeConquistaYUnaComunYJugadorCompletaLaMisionComunYGana () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionConquista);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(30);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(3);

        assertTrue(jugador.gano());
    }

    @Test
    public void test21AgregoUnaMisionDeConquistaYUnaComunYJugadorCompletaLaMisionDeConquistaYGana () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionConquista);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(29);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(4);

        assertTrue(jugador.gano());
    }

    @Test
    public void test22AgregoUnaMisionDeConquistaYUnaComunYJugadorCompletaAmbasYGana () {
        Juego juegoMock = mock(Juego.class);
        Map<String, Integer> objetivos = new HashMap<>();
        objetivos.put("Asia", 2);
        objetivos.put("Oceania", 4);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionConquista misionConquista = new MisionConquista(jugador, juegoMock, objetivos);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionConquista);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(30);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Asia")).thenReturn(2);
        when(juegoMock.paisesConquistadosPorEn(jugador, "Oceania")).thenReturn(4);

        assertTrue(jugador.gano());
    }

    @Test
    public void test23AgregoUnaMisionDeDestruccionYUnaComunYJugadorNoCompletaNinguna () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(29);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(1);

        assertFalse(jugador.gano());
    }

    @Test
    public void test24AgregoUnaMisionDeDestruccionYUnaComunYJugadorCompletaLaDeDestruccionYGana () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(29);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(0);

        assertTrue(jugador.gano());
    }

    @Test
    public void test25AgregoUnaMisionDeDestruccionYUnaComunYJugadorCompletaLaComunYGana () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(32);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(2);

        assertTrue(jugador.gano());
    }

    @Test
    public void test26AgregoUnaMisionDeDestruccionYUnaComunYJugadorCompletaAmbasYGana () {
        Juego juegoMock = mock(Juego.class);
        MisionComun misionComun = new MisionComun(jugador, juegoMock, 30);
        MisionDestruccion misionDestruccion = new MisionDestruccion(juegoMock, otroJugador);
        jugador.agregarMision(misionComun);
        jugador.agregarMision(misionDestruccion);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador)).thenReturn(32);
        when(juegoMock.obtenerCantidadPaisesSegunJugador(otroJugador)).thenReturn(0);

        assertTrue(jugador.gano());
    }

}
