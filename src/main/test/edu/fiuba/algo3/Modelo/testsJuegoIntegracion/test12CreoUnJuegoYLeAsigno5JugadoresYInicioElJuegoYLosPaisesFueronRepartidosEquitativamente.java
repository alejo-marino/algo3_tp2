package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test12CreoUnJuegoYLeAsigno5JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
    Juego juego = Juego();

    juego.agregarJugadores(5);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);
	for (i=0; i < len(tablero.listaJugadores); i++)
            if (cantPaises(tablero.listaJugadores[i]) != 10):
    cantidadPaisesIncorrecta = true.
            break;
    assertTrue(cantidadPaisesIncorrecta);
}

