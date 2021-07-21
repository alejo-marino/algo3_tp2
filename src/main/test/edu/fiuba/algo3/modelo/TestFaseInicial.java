package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestFaseInicial {

    private Tablero tablero;
    private FaseInicial faseInicial;

    @BeforeEach
    void setUp() {
        this.tablero = new Tablero(null, null);
        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);
        this.faseInicial = new FaseInicial(cola, tablero);
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
