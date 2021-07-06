package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test10CreoUnJuegoYLeAsigno3JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
    Juego juego = Juego();

    juego.agregarJugadores(3);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);

    int cont16 = 0;
    int cont17 = 0;
	for (i=0; i < len(tablero.listaJugadores); i++)
            if (cantPaises(tablero.listaJugadores[i] == 17) {
        cont17++;
    } else if (cantPaises(tablero.listaJugadores[i] == 16) {
        cont16++;
    };

    assertTrue(cont16 == 1 && cont17 == 2);
}

