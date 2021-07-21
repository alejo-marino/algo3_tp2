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

    private Integer BONUS_AMERICA_DEL_SUR = 3;

    @BeforeEach
    void setUp() {
        this.continente = new Continente("America Del Sur", BONUS_AMERICA_DEL_SUR);
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
        assertEquals(BONUS_AMERICA_DEL_SUR, continente.obtenerBonusDeContinentePara(jugador1));
    }

    @Test
    public void test03SeCreaUnContinenteConDosPaisesConUnMismoDuenioYVerificaQueEseDuenioDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(chile);

        assertEquals(BONUS_AMERICA_DEL_SUR, continente.obtenerBonusDeContinentePara(jugador1));
    }

    @Test
    public void test04SeCreaUnContinenteConDosPaisesConDistintoDuenioYVerificaQueNingunoDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(uruguay);

        assertEquals(0, continente.obtenerBonusDeContinentePara(jugador1));
        assertEquals(0, continente.obtenerBonusDeContinentePara(jugador2));
    }

    @Test
    public void test05SeCreaUnContinenteSinPaisesYVerificaQueUnJugadorNoDomineElContinente () {
        assertEquals(0, continente.obtenerBonusDeContinentePara(jugador1));
    }

    @Test
    public void test06SeCreaContinenteCon2PaisesDeDistintoDuenioYUnPaisConquistaAlOtroYVerificaQueElDuenioDeEsePaisDomineElContinente () {
        continente.agregarPais(argentina);
        continente.agregarPais(uruguay);
        argentina.conquistar(uruguay);

        assertEquals(BONUS_AMERICA_DEL_SUR, continente.obtenerBonusDeContinentePara(jugador1));
    }

    @Test
    public void test07SeCreaContinenteConNombreYDevuelveElNombreCorrecto () {
        assertEquals("America Del Sur", continente.toString());
    }

    @Test
    public void test08SeCreaContinenteCon2PaisesDeJugador1YVerificoQueControle2Paises () {
        continente.agregarPais(argentina);
        continente.agregarPais(chile);

        assertEquals(2, continente.paisesConquistadosPor(jugador1));
    }

    @Test
    public void test09SeCreaContinenteCon2PaisesDeJugador1YJugador2Conquista1YVerificoQueJugador1Controle1Pais () {
        continente.agregarPais(argentina);
        continente.agregarPais(chile);
        continente.agregarPais(uruguay);
        uruguay.conquistar(argentina);

        assertEquals(1, continente.paisesConquistadosPor(jugador1));
    }

    @Test
    public void test10SeCreaContinenteCon2PaisesDeJugador1YJugador2Conquista1YVerificoQueJugador2Controle2Paises () {
        continente.agregarPais(argentina);
        continente.agregarPais(chile);
        continente.agregarPais(uruguay);
        uruguay.conquistar(argentina);

        assertEquals(2, continente.paisesConquistadosPor(jugador2));
    }

}
