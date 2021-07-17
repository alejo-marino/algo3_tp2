package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestContinente {

    @Test
    public void test01SeCreaUnContinenteYNoEsNull () {
        Continente continente = new Continente("America Del Sur");
        assertNotNull(continente);
    }

    @Test
    public void test02SeCreaUnContinenteConUnPaisYVerificaQueElDuenioDeEsePaisDomineElContinente () {
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);
        continente.agregarPais(pais);
        assertTrue(continente.esDominadoPor(jugador));
    }

    @Test
    public void test03SeCreaUnContinenteConDosPaisesConUnMismoDuenioYVerificaQueEseDuenioDomineElContinente () {
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");
        Pais argentina = new Pais("Argentina", jugador);
        Pais uruguay = new Pais("Uruguay", jugador);
        continente.agregarPais(argentina);
        continente.agregarPais(uruguay);
        assertTrue(continente.esDominadoPor(jugador));
    }

    @Test
    public void test04SeCreaUnContinenteConDosPaisesConDistintoDuenioYVerificaQueNingunoDomineElContinente () {
        Continente continente = new Continente("America Del Sur");
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Pais pais1 = new Pais("Argentina", jugador1);
        Pais pais2 = new Pais("Uruguay", jugador2);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        assertFalse(continente.esDominadoPor(jugador1));
        assertFalse(continente.esDominadoPor(jugador2));
    }

    @Test
    public void test05SeCreaUnContinenteSinPaisesYVerificaQueUnJugadorNoDomineElContinente () {
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");

        assertFalse(continente.esDominadoPor(jugador));
    }

    @Test
    public void test06SeCreaContinenteCon2PaisesDeDistintoDuenioYUnPaisConquistaAlOtroYVerificaQueElDuenioDeEsePaisDomineElContinente () {
        Continente continente = new Continente("America Del Sur");
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Pais pais1 = new Pais("Argentina", jugador1);
        Pais pais2 = new Pais("Argentina", jugador2);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        pais1.conquistar(pais2);

        assertTrue(continente.esDominadoPor(jugador1));
    }

    @Test
    public void test07SeCreaContinenteConNombreYDevuelveElNombreCorrecto () {
        String nombre = "America Del Sur";
        Continente continente = new Continente(nombre);
        assertEquals(nombre, continente.toString());
    }

}
