package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test09CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
    Juego juego = Juego();

    juego.agregarJugadores(2);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);
    for (i=0; i < len(tablero.listaJugadores); i++)
        if (cantPaises(tablero.listaJugadores[i]) != 25):
        cantidadPaisesIncorrecta = true.
        break;
        assertTrue(cantidadPaisesIncorrecta);
}

