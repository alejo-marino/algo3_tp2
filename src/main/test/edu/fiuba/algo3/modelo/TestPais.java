package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestPais {

    private Jugador jugador1;
    private Pais argentina;
    private Pais uruguay;
    private Pais chile;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        this.argentina = new Pais("Argentina", jugador1);
        this.uruguay = new Pais("Uruguay", jugador2);
        this.chile = new Pais("Chile", jugador1);
    }

    @Test
    public void test01CreoUnPaisYNoEsNull (){
        assertNotNull(argentina);
    }

    @Test
    public void test02CreoUnPaisYLeAsignoDuenio (){
        assertEquals(argentina.getDuenio(), jugador1);
    }

    @Test
    public void test03CreoUnPaisYTieneUnEjercito (){
        assertEquals(argentina.getEjercitos(), 1);
    }

    @Test
    public void test04CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneTresEjercitos (){
        argentina.reforzar(2);
        assertEquals(argentina.getEjercitos(), 3);
    }

    @Test
    public void test05CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneDosEjercitosParaAtacar (){
        argentina.reforzar(2);
        assertEquals(argentina.getEjercitosParaAtacar(), 2);
    }

    @Test
    public void test06CreoUnPaisYLoRefuerzoConDiezEjercitosYAhoraTieneTresEjercitosParaAtacar(){
        argentina.reforzar(10);
        assertEquals(argentina.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test07Pais1ConquistaAPais2YPais2EsAliadoDePais1(){
        argentina.conquistar(uruguay);
        assertTrue(argentina.esAliado(uruguay));
    }

    @Test
    public void test08DosPaisesDeUnJugadorSonAliados(){
        assertTrue(argentina.esAliado(chile));
    }

    @Test
    public void test09CreoUnPaisYRefuerzo5YTiene3EjercitosParaDefender(){
        argentina.reforzar(5);
        assertEquals(3, argentina.getEjercitosParaDefender());
    }

    @Test
    public void test10CreoUnPaisYTiene1EjercitoParaDefender(){
        assertEquals(1, argentina.getEjercitosParaDefender());
    }
}