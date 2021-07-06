package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test04CreoUnJuegoYLeAsigno7JugadoresYLaCantidadNoEsValida{
    Juego juego = Juego();
    assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(7));
}

