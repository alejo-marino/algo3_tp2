package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestFaseInicial {

    private FaseInicial faseInicial;

    @BeforeEach
    void setUp() {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);
        Juego juegoMock = mock(Juego.class);
        this.faseInicial = new FaseInicial(cola, juegoMock);
    }

    @Test
    public void test01SeCreaUnaFaceInicialYNoEsNull() {
        assertNotNull(faseInicial);
    }

    @Test
    public void test02SeCreaUnaFaceInicialYEsLaCorrecta() {
        assertEquals("Fase inicial", faseInicial.getFaseActual());
    }

    @Test
    public void test03SeCreaUnaFaceInicialYLaSiguienteSiguieFaseInicial() {
        faseInicial.siguienteRonda();
        assertEquals("Fase inicial", faseInicial.getFaseActual());
    }

    @Test
    public void test04SeCreaUnaFaceInicialYSeColocanCincoEjercitos() {
        assertEquals("Colocando 5 ejercitos", faseInicial.getRondaActual());
    }

    @Test
    public void test05SeCreaUnaFaseInicialYLaSiguienteEsDeColocarCinco() {
        faseInicial.siguienteRonda();
        assertEquals("Colocando 3 ejercitos", faseInicial.getRondaActual());
    }

}
