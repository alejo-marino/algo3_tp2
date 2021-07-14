package edu.fiuba.algo3.modelo;

public class TestContinente{
    // por ahora vacio, debera checkear que todos los paises contenidos en el mismo esten o no conquistados por un mismo jugador
    /*
    @Test
    public void test01SeCreaUnContinenteYNoEsNull{
        Continente continente = new Continente("America Del Sur");
        assertNotNull(continente);
    }

    public void test02SeCreaUnContinenteConUnPaisYVerificaQueElDueñoDeEsePaisDomineElContinente{
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais(jugador);
        continente.agregarPais(pais);
        assertTrue(continente.esDominadoPor(jugador));
    }

    public void test03SeCreaUnContinenteConDosPaisesConUnMismoDueñoYVerificaQueEseDueñoDomineElContinente{
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");
        Pais pais1 = new Pais(jugador);
        Pais pais2 = new Pais(jugador);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        assertTrue(continente.esDominadoPor(jugador));
    }

    public void test04SeCreaUnContinenteConDosPaisesConDistintoDueñoYVerificaQueNingunoDomineElContinente{
        Continente continente = new Continente("America Del Sur");
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Pais pais1 = new Pais(jugador1);
        Pais pais2 = new Pais(jugador2);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        assertFalse(continente.esDominadoPor(jugador1));
        assertFalse(continente.esDominadoPor(jugador2));
    }

    public void test05SeCreaUnContinenteSinPaisesYVerificaQueUnJugadorNoDomineElContinente{
        Continente continente = new Continente("America Del Sur");
        Jugador jugador = new Jugador("000000");

        assertFalse(continente.esDominadoPor(jugador));
    }

    public void test06SeCreaContinenteCon2PaisesDeDistintoDueñoYUnPaisConquistaAlOtroYVerificaQueElDueñoDeEsePaisDomineElContinente{
        Continente continente = new Continente("America Del Sur");
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Pais pais1 = new Pais(jugador1);
        Pais pais2 = new Pais(jugador2);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        pais1.conquistar(pais2);

        assertTrue(continente.esDominadoPor(jugador1));
    }

     */
}
