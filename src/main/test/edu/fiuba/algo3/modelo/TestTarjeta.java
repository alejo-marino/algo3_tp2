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
        this.argentina = new Pais("Argentina", jugador);
        this.tarjetaGlobo = new Tarjeta(argentina, "Globo");
        this.uruguay = new Pais("Uruguay", jugador2);
        this.tarjetaBarco = new Tarjeta(uruguay, "Barco");
        Pais china = new Pais("China", jugador3);
        this.tarjetaBarco2 = new Tarjeta(china, "Barco");

        this.cantidadEjercitosActivacion = 2;
    }

    @Test
    public void test01CreoUnaTarjetaYNoEsNull () {
        assertNotNull(tarjetaGlobo);
    }

    @Test
    public void test02CreoUnaTarjetaDeUnPaisQueDominoYLaActivoYMeDevuelveElValorCorrecto () {
        tarjetaGlobo.activar(jugador);
        assertEquals(cantidadEjercitosActivacion + 1, argentina.getEjercitos());
    }

    @Test
    public void test03NoPuedoActivarUnaTarjetaDosVecesSinAntesDevolverlaAlMazo () {
        tarjetaGlobo.activar(jugador);

        assertThrows(ActivacionTarjetaInvalidaException.class, () -> tarjetaGlobo.activar(jugador));
    }

    @Test
    public void test05ActivoUnaTarjetaYLaDevuelvoAlMazoYPuedoActivarlaDeNuevo () {
        tarjetaGlobo.activar(jugador);
        tarjetaGlobo.hacerActivable();
        tarjetaGlobo.activar(jugador);
        assertEquals(2 * cantidadEjercitosActivacion + 1, argentina.getEjercitos());
    }

    @Test
    public void test06ConquistoUnPaisYPuedoActivarLaTarjeta () {
        argentina.reforzar(1);
        argentina.conquistar(uruguay);
        tarjetaBarco.activar(jugador);
        assertEquals(cantidadEjercitosActivacion + 2, uruguay.getEjercitos());
    }

    @Test
    public void test07VerificoQueDosTarjetasTienenDistintosSimbolos () {
        assertNotEquals(tarjetaGlobo, tarjetaBarco);
    }

    @Test
    public void test08VerificoQueDosTarjetasTienenIgualSimbolo () {
        assertEquals(tarjetaBarco, tarjetaBarco2);
    }

    @Test
    public void test09CreoUnaTarjetaYVerificoQueElSimboloSeaElCorrecto () {
        String simbolo = "Globo";
        assertEquals(simbolo, tarjetaGlobo.getSimbolo());
    }

    @Test
    public void test10NoPuedoCanjearTarjetaDeUnPaisAjeno() {
        assertThrows(ActivacionTarjetaInvalidaException.class, () -> tarjetaBarco.activar(jugador));
    }

}
