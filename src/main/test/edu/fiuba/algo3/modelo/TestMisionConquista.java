package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


public class TestMisionConquista {

    private Jugador jugador1;
    private Jugador jugador2;
    private MisionConquista misionConquista;;
    private Juego juegoMock;


    @BeforeEach
    public void setUp () {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");

        this.juegoMock = mock(Juego.class);

        Map<String, Integer> paisesAConquistar = new HashMap<>();
        paisesAConquistar.put("Oceania", 4);
        paisesAConquistar.put("Asia", 2);
        this.misionConquista = new MisionConquista(juegoMock, paisesAConquistar);
        misionConquista.asignarJugador(jugador1);
    }

    @Test
    public void test01CreoUnaMisionYNoEsNull(){
        assertNotNull(misionConquista);
    }

    @Test
    public void test02CreoUnaMisionYLePidoElObjetivo () {
        String mision = misionConquista.verMision();
        assertTrue(mision.contains("4 países de Oceania"));
        assertTrue(mision.contains("2 países de Asia"));
    }

    @Test
    public void test03CreoUnaMisionDeConquistaYElJugadorCompletaMinimamente(){
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Oceania")).thenReturn(4);
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Asia")).thenReturn(2);
        assertTrue(misionConquista.completoMision());
    }

    @Test
    public void test04CreoUnaMisionDeConquistaYElJugadorCompletaConMasDeLoNecesario() {
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Oceania")).thenReturn(4);
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Asia")).thenReturn(5);
        assertTrue(misionConquista.completoMision());
    }

    @Test
    public void test05CreoUnaMisionDeConquistaYElJugadorNoLaCompleta() {
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Oceania")).thenReturn(3);
        when(juegoMock.paisesConquistadosPorEn(jugador1, "Asia")).thenReturn(5);
        assertFalse(misionConquista.completoMision());
    }

    @Test
    public void test06CreoMisionConquistaYSiempreEsPosible() {
        assertTrue(misionConquista.sigueSiendoPosible());
    }

}
