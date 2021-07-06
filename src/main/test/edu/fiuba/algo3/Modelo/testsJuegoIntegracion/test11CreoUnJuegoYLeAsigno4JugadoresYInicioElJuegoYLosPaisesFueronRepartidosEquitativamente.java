package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test11CreoUnJuegoYLeAsigno4JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
    Juego juego = Juego();

    juego.agregarJugadores(4);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);

    int cont12 = 0;
    int cont13 = 0;
	for (i=0; i < len(tablero.listaJugadores); i++)
            if (cantPaises(tablero.listaJugadores[i] == 12) {
        cont12++;
    } else if (cantPaises(tablero.listaJugadores[i] == 13) {
        cont13+;
    };

    assertTrue(cont12 == 2 && cont13 == 2);
}
