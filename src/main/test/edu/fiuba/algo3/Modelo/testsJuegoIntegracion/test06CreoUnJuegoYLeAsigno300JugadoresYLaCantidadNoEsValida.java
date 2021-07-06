package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test06CreoUnJuegoYLeAsigno300JugadoresYLaCantidadNoEsValida{
    Juego juego = Juego();
    assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(300));
}

