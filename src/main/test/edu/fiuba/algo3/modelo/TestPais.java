package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestPais {


    @Test
    public void test01CreoUnPaisYNoEsNull (){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);

        assertNotNull(pais);
    }

    @Test
    public void test02CreoUnPaisYLeAsignoDuenio (){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);

        assertEquals(pais.getDuenio(), jugador);
    }

    @Test
    public void test03CreoUnPaisYTieneUnEjercito (){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);
        assertEquals(pais.getEjercitos(), 1);
    }

    @Test
    public void test04CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneTresEjercitos (){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);
        pais.reforzar(2);
        assertEquals(pais.getEjercitos(), 3);
    }

    @Test
    public void test05CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneDosEjercitosParaAtacar (){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);
        pais.reforzar(2);
        assertEquals(pais.getEjercitosParaAtacar(), 2);
    }

    @Test
    public void test06CreoUnPaisYLoRefuerzoConDiezEjercitosYAhoraTieneTresEjercitosParaAtacar(){
        Jugador jugador = new Jugador("000000");
        Pais pais = new Pais("Argentina", jugador);
        pais.reforzar(10);
        assertEquals(pais.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test07Pais1ConquistaAPais2YPais2EsAliadoDePais1(){
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");

        Pais pais1 = new Pais("Argentina",jugador1);
        Pais pais2 = new Pais("Uruguay", jugador2);
        pais1.conquistar(pais2);
        assertTrue(pais1.esAliado(pais2));
    }

    @Test
    public void test08DosPaisesDeUnJugadorSonAliados(){
        Jugador jugador1 = new Jugador("000000");
        Pais pais1 = new Pais("Argentina",jugador1);
        Pais pais2 = new Pais("Uruguay", jugador1);
        assertTrue(pais1.esAliado(pais2));
    }

    @Test
    public void test09CreoUnPaisYRefuerzo5YTiene3EjercitosParaDefender(){
        Jugador jugador1 = new Jugador("000000");
        Pais argentina = new Pais("Argentina",jugador1);
        argentina.reforzar(5);
        assertEquals(3, argentina.getEjercitosParaDefender());
    }

    @Test
    public void test10CreoUnPaisYTiene1EjercitoParaDefender(){
        Jugador jugador1 = new Jugador("000000");
        Pais argentina = new Pais("Argentina",jugador1);
        assertEquals(1, argentina.getEjercitosParaDefender());
    }
}