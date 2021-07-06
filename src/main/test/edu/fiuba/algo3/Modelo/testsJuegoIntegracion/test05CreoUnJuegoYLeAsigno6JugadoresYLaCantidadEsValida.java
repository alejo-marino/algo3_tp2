package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test05CreoUnJuegoYLeAsigno6JugadoresYLaCantidadEsValida{
    Juego juego = Juego();
    assertEquals(obtenerCantJugadores(juego), 6);
}

