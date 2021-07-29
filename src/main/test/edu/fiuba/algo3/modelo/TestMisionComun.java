package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestMisionComun {

    private Jugador jugador1;
    private Juego juegoMock;
    private MisionComun misionComun;
    private Integer cantidadDePaisesParaGanar;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Negro");
        this.juegoMock = mock(Juego.class);
        this.cantidadDePaisesParaGanar = 30;
        this.misionComun = new MisionComun(jugador1, juegoMock, cantidadDePaisesParaGanar);
    }

    @Test
    public void test01CreoMisionDeDestruccionyNoEsNull(){
        assertNotNull(misionComun);
    }

    @Test
    public void test02CreoMisionComunYLePidoElObjetivo () {
       assertTrue(misionComun.verMision().contains(cantidadDePaisesParaGanar.toString()));
    }

    @Test
    public void test03CreoMisionComunYElJugador1TienePaisesNecesarios () {
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(30);
        assertTrue(misionComun.completoMision());
        verify(juegoMock).obtenerCantidadPaisesSegunJugador(jugador1);
    }

    @Test
    public void test04CreoMisionComunYElJugador1NoTienePaisesNecesarios () {
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador1)).thenReturn(1);
        assertFalse(misionComun.completoMision());
        verify(juegoMock).obtenerCantidadPaisesSegunJugador(jugador1);
    }

    @Test
    public void test05CreoMisionComunYSiempreEsPosible(){
        assertTrue(misionComun.sigueSiendoPosible());
    }

}
