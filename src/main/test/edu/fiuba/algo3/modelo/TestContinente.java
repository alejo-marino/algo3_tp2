package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestContinente {

    private Continente continente;
    private Jugador jugador1;
    private Jugador jugador2;
    private Pais argentina;
    private Pais uruguay;
    private Pais chile;

    @BeforeEach
    void setUp() {
        this.continente = new Continente("America Del Sur");
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        this.argentina = new Pais("Argentina", jugador1);
        this.uruguay = new Pais("Uruguay", jugador2);
        this.chile = new Pais("Chile", jugador1);
    }

    @Test
    public void test01SeCreaUnContinenteYNoEsNull () {
        assertNotNull(continente);
    }

    @Test
    public void test02SeCreaUnContinenteConUnPaisYVerificaQueElDuenioDeEsePaisDomineElContinente () {
        continente.agregarPais(argentina);
        assertTrue(continente.esDominadoPor(jugador1));
    }

    @Test
    public void test03SeCreaUnContinenteConDosPaisesConUnMismoDuenioYVerificaQueEseDuenioDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(chile);

        assertTrue(continente.esDominadoPor(jugador1));
    }

    @Test
    public void test04SeCreaUnContinenteConDosPaisesConDistintoDuenioYVerificaQueNingunoDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(uruguay);

        assertFalse(continente.esDominadoPor(jugador1));
        assertFalse(continente.esDominadoPor(jugador2));
    }

    @Test
    public void test05SeCreaUnContinenteSinPaisesYVerificaQueUnJugadorNoDomineElContinente () {
        assertFalse(continente.esDominadoPor(jugador1));
    }

    @Test
    public void test06SeCreaContinenteCon2PaisesDeDistintoDuenioYUnPaisConquistaAlOtroYVerificaQueElDuenioDeEsePaisDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(uruguay);
        argentina.conquistar(uruguay);

        assertTrue(continente.esDominadoPor(jugador1));
    }

    @Test
    public void test07SeCreaContinenteConNombreYDevuelveElNombreCorrecto () {
        assertEquals("America Del Sur", continente.toString());
    }

}
