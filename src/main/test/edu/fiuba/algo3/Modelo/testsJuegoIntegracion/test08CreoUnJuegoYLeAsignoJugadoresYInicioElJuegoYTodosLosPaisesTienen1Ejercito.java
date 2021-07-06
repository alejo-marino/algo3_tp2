package edu.fiuba.algo3.Modelo.testsJuegoIntegracion;

public class test08CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienen1Ejercito
	Juego juego = Juego();

    juego.agregarJugadores(6);
    juego.inicializarJuego;
    Tablero tablero = obtenerTablero(juego);
    boolean cantidadEjercitosIncorrecta = false;
    for (i=0; i < len(tablero.listaPaises); i++)
        if (cantPaises(tablero.listaPaises[i]) != 1)
            cantidadEjercitosIncorrecta = true.
            break;
        assertTrue(cantidadEjercitosIncorrecta);
        }

