package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTarjeta {

    private Tarjeta tarjetaGlobo;
    private Tarjeta tarjetaBarco;
    private Tarjeta tarjetaBarco2;
    private Jugador jugador;
    private Jugador jugador2;
    private Pais argentina;
    private Pais uruguay;

    private Integer cantidadEjercitosActivacion;


    @BeforeEach
    void setUp() {
        this.jugador = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("fff000");
        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador);
        tarjetaGlobo = new Tarjeta(argentina, "Globo");
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        tarjetaBarco = new Tarjeta(uruguay, "Barco");
        Pais china = new Pais("China");
        china.asignarDuenio(jugador3);
        tarjetaBarco2 = new Tarjeta(china, "Barco");

        cantidadEjercitosActivacion = 2;
    }

    @Test
    public void test01CreoUnaTarjetaYNoEsNull () {
        assertNotNull(tarjetaGlobo);
    }

    @Test
    public void test02CreoUnaTarjetaDeUnPaisQueDominoYLaActivoYMeDevuelveElValorCorrecto () {
        tarjetaGlobo.darA(jugador);
        tarjetaGlobo.activar();
        assertEquals(cantidadEjercitosActivacion + 1, argentina.getEjercitos());
    }

    @Test
    public void test03NoPuedoActivarUnaTarjetaDosVecesSinAntesDevolverlaAlMazo () {
        tarjetaGlobo.darA(jugador);
        tarjetaGlobo.activar();

        assertThrows(ActivacionTarjetaInvalidaException.class, () -> tarjetaGlobo.activar());
    }

    @Test
    public void test05ActivoUnaTarjetaYLaDevuelvoAlMazoYPuedoActivarlaDeNuevo () {
        tarjetaGlobo.darA(jugador);
        tarjetaGlobo.activar();
        tarjetaGlobo.devolverAlMazo();
        tarjetaGlobo.darA(jugador);
        tarjetaGlobo.activar();
        assertEquals(2 * cantidadEjercitosActivacion + 1, argentina.getEjercitos());
    }

    @Test
    public void test06ConquistoUnPaisYPuedoActivarLaTarjeta () {
        tarjetaBarco.darA(jugador);
        argentina.reforzar(1);
        argentina.conquistar(uruguay);
        tarjetaBarco.activar();
        assertEquals(cantidadEjercitosActivacion + 2, uruguay.getEjercitos());
    }

    @Test
    public void test07VerificoQueDosTarjetasTienenDistintosSimbolos () {
        assertNotEquals(tarjetaGlobo, tarjetaBarco);
    }

    @Test
    public void test08VerificoQueDosTarjetasTienenIgualSimbolo () {
        assertTrue(tarjetaBarco.tieneIgualSimbolo(tarjetaBarco2));
    }

    @Test
    public void test09CreoUnaTarjetaYVerificoQueElSimboloSeaElCorrecto () {
        String simbolo = "Globo";
        assertEquals(simbolo, tarjetaGlobo.getSimbolo());
    }

    @Test
    public void test10NoPuedoCanjearTarjetaDeUnPaisAjeno() {
        tarjetaBarco.darA(jugador);
        assertThrows(ActivacionTarjetaInvalidaException.class, () -> tarjetaBarco.activar());
    }

}
