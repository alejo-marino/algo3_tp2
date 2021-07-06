package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test03CreoUnJuegoYLeAsigno1JugadoresYLaCantidadNoEsValida{
    Juego juego = Juego();
    assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(1));
}

