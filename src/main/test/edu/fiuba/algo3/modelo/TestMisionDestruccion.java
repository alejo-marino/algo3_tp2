package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestMisionDestruccion {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juegoMock;
    private MisionDestruccion misionDestruccion;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Negro", "Jugador 1");
        this.jugador2 = new Jugador("Rojo", "Jugador 2");

        this.juegoMock = mock(Juego.class);

        Map<String, Integer> paisesAConquistar = new HashMap<>();
        paisesAConquistar.put("Oceania", 4);
        paisesAConquistar.put("Asia", 2);
        this.misionDestruccion = new MisionDestruccion(juegoMock, jugador2);
    }

    @Test
    public void test01CreoMisionDeDestruccionyNoEsNull() {
        assertNotNull(misionDestruccion);
    }

    @Test
    public void test02CreoMisionDeDestruccionYLePidoElObjetivo () {
        String objetivo = "Rojo";
        assertTrue(misionDestruccion.verMision().contains(objetivo));
    }

    @Test
    public void test03CreoMisionDeDestruccionYElJugador1DestruyoAlJugador2 () {
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(0);
        assertTrue(misionDestruccion.completoMision());
        verify(juegoMock).obtenerCantidadPaisesSegunJugador(jugador2);
    }

    @Test
    public void test03CreoMisionDeDestruccionYElJugador1NoDestruyeAJugador2 () {
        when(juegoMock.obtenerCantidadPaisesSegunJugador(jugador2)).thenReturn(1);
        assertFalse(misionDestruccion.completoMision());
        verify(juegoMock).obtenerCantidadPaisesSegunJugador(jugador2);
    }
}
