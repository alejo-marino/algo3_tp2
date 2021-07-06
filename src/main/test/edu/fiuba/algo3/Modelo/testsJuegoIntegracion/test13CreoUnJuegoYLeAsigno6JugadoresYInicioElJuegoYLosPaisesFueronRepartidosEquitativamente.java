package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test13CreoUnJuegoYLeAsigno6JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
    Juego juego = Juego();

    juego.agregarJugadores(6);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);

    int cont8 = 0;
    int cont9 = 0;
	for (i=0; i < len(tablero.listaJugadores); i++)
            if (cantPaises(tablero.listaJugadores[i] == 9) {
        cont9++;
    } else if (cantPaises(tablero.listaJugadores[i] == 8) {
        cont8+;
    };

    assertTrue(cont8 == 4 && cont9 == 2);
}
