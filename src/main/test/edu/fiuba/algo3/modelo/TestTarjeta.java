package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTarjeta {

    private Tarjeta tarjetaGlobo;
    private Tarjeta tarjetaBarco;
    private Tarjeta tarjetaBarco2;
    private Jugador jugador;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;

    private Integer cantidadEjercitosActivacion;

    @BeforeEach
    void setUp() {
        this.jugador = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("fff000");
        this.argentina = new Pais("Argentina", jugador);
        this.tarjetaGlobo = new Tarjeta(argentina, "Globo");
        this.uruguay = new Pais("Argentina", jugador2);
        this.tarjetaBarco = new Tarjeta(uruguay, "Barco");
        this.china = new Pais("China", jugador3);
        this.tarjetaBarco2 = new Tarjeta(china, "Barco");

        this.cantidadEjercitosActivacion = 3;
    }

    @Test
    public void test01CreoUnaTarjetaYNoEsNull () {
        assertNotNull(tarjetaGlobo);
    }

    @Test
    public void test02CreoUnaTarjetaDeUnPaisQueDominoYLaActivoYMeDevuelveElValorCorrecto () {
        assertEquals(cantidadEjercitosActivacion, tarjetaGlobo.activar(jugador));
    }

    @Test
    public void test03NoPuedoActivarUnaTarjetaDosVecesSinAntesDevolverlaAlMazo () {
        tarjetaGlobo.activar(jugador);
        assertEquals(0, tarjetaGlobo.activar(jugador));
    }

    @Test
    public void test04NoPuedoActivarUnaTarjetaDeUnPaisQueNoMePertenece () {
        assertEquals(0, tarjetaBarco.activar(jugador));
    }

    @Test
    public void test05ActivoUnaTarjetaYLaDevuelvoAlMazoYPuedoActivarlaDeNuevo () {
        tarjetaGlobo.activar(jugador);
        tarjetaGlobo.reiniciarEstado();
        assertEquals(cantidadEjercitosActivacion, tarjetaGlobo.activar(jugador));
    }

    @Test
    public void test06ConquistoUnPaisYPuedoActivarLaTarjeta () {
        argentina.conquistar(uruguay);
        assertEquals(cantidadEjercitosActivacion, tarjetaBarco.activar(jugador));
    }

    @Test
    public void test07VerificoQueDosTarjetasTienenDistintosSimbolos () {
        assertNotEquals(tarjetaGlobo, tarjetaBarco);
    }

    @Test
    public void test08VerificoQueDosTarjetasTienenIgualSimbolo () {
        assertEquals(tarjetaBarco, tarjetaBarco2);
    }

}
