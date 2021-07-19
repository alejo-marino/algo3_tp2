package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestFaseInicial {

    @Test
    public void test01SeCreaUnaFaceInicialYNoEsNull() {
        Queue<Integer> cola = new LinkedList<>();
        Tablero tablero = new Tablero(null);
        cola.add(5);
        cola.add(3);
        FaseInicial faseInicial = new FaseInicial(cola, tablero);
        assertNotNull(faseInicial);
    }

    @Test
    public void test02SeCreaUnaFaceInicialYEsLaCorrecta() {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);
        Tablero tablero = new Tablero(null);

        FaseInicial faseInicial = new FaseInicial(cola, tablero);

        assertEquals("Fase inicial", faseInicial.getFaseActual());
    }

    @Test
    public void test03SeCreaUnaFaceInicialYLaSiguienteSiguieFaseInicial() {
        Queue<Integer> cola = new LinkedList<>();
        Tablero tablero = new Tablero(null);
        cola.add(5);
        cola.add(3);
        FaseInicial faseInicial = new FaseInicial(cola, tablero);
        faseInicial.siguienteRonda();
        assertEquals("Fase inicial", faseInicial.getFaseActual());
    }

    @Test
    public void test04SeCreaUnaFaceInicialYSeColocanCincoFichas() {
        Queue<Integer> cola = new LinkedList<>();
        Tablero tablero = new Tablero(null);
        cola.add(5);
        cola.add(3);
        FaseInicial faseInicial = new FaseInicial(cola, tablero);

        assertEquals("Colocando 5 ejercitos", faseInicial.getRondaActual());
    }

    @Test
    public void test05SeCreaUnaFaseInicialYLaSiguienteEsDeColocarCinco() {
        Queue<Integer> cola = new LinkedList<>();
        Tablero tablero = new Tablero(null);
        cola.add(5);
        cola.add(3);
        FaseInicial faseInicial = new FaseInicial(cola, tablero);
        faseInicial.siguienteRonda();
        assertEquals("Colocando 3 ejercitos", faseInicial.getRondaActual());
    }

}
