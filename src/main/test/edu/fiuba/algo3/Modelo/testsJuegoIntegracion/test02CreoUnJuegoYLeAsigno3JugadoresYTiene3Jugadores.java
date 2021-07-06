package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test02CreoUnJuegoYLeAsigno3JugadoresYTiene3Jugadores{
    Juego juego = Juego();
    agregarJugadores(3);

    assertEquals(obtenerCantJugadores(juego), 3)

}
