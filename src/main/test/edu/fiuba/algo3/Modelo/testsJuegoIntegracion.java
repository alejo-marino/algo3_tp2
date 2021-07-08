package edu.fiuba.algo3.Modelo;

public class testsJuegoIntegracion {

    public test01CreoUnJuegoYNoEsNull {
        Juego juego = Juego();
        assertNotNull(juego);
    }

    public test02CreoUnJuegoYLeAsigno3JugadoresYTiene3Jugadores {
        Juego juego = Juego();
        agregarJugadores(3);

        assertEquals(obtenerCantJugadores(juego), 3)
    }

    public test03CreoUnJuegoYLeAsigno1JugadoresYLaCantidadNoEsValida {
        Juego juego = Juego();
        assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(1));
    }

    public test04CreoUnJuegoYLeAsigno7JugadoresYLaCantidadNoEsValida {
        Juego juego = Juego();
        assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(7));
    }

    public test05CreoUnJuegoYLeAsigno6JugadoresYLaCantidadEsValida {
        Juego juego = Juego();
        assertEquals(obtenerCantJugadores(juego), 6);
    }

    public test06CreoUnJuegoYLeAsigno300JugadoresYLaCantidadNoEsValida {
        Juego juego = Juego();
        assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(300));
    }

    public test07CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienenDueño {
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);

        assertEquals(len(tablero.listaPaisesVacios, 0)
    }

    public test08CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienen1Ejercito {
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        boolean cantidadEjercitosIncorrecta = false;
        for (int i=0; i < len(tablero.listaPaises); i++) {
            if (cantPaises(tablero.listaPaises[i]) != 1) {
                cantidadEjercitosIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadEjercitosIncorrecta);
    }

    public test09CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i]) != 25) {
                cantidadPaisesIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadPaisesIncorrecta);
    }

    public test10CreoUnJuegoYLeAsigno3JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
        Juego juego = Juego();

        juego.agregarJugadores(3);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont16 = 0;
        int cont17 = 0;

	    for (int i=0; i < len(tablero.listaJugadores); i++) {
	        if (cantPaises(tablero.listaJugadores[i] == 17))
                cont17++;
            else if (cantPaises(tablero.listaJugadores[i] == 16))
                    cont16++;
        }
        assertTrue(cont16 == 1 && cont17 == 2);
    }

    public test11CreoUnJuegoYLeAsigno4JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
        Juego juego = Juego();

        juego.agregarJugadores(4);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont12 = 0;
        int cont13 = 0;

	    for (int i=0; i < len(tablero.listaJugadores); i++) {
	        if (cantPaises(tablero.listaJugadores[i] == 12))
                cont12++;
	        else if (cantPaises(tablero.listaJugadores[i] == 13))
            cont13++;
        }
        assertTrue(cont12 == 2 && cont13 == 2);
    }

    public test12CreoUnJuegoYLeAsigno5JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
        Juego juego = Juego();

        juego.agregarJugadores(5);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);

	    for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i]) != 10) {
                cantidadPaisesIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadPaisesIncorrecta);
    }

    public test13CreoUnJuegoYLeAsigno6JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente {
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont8 = 0;
        int cont9 = 0;

	    for (int i=0; i < len(tablero.listaJugadores); i++) {
	        if (cantPaises(tablero.listaJugadores[i] == 9))
                cont9++;
            else if (cantPaises(tablero.listaJugadores[i] == 8))
                cont8++;
	    }
        assertTrue(cont8 == 4 && cont9 == 2);
    }

    public test14CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneEjercitosEnUnPaisAjeno {
        Juego juego = Juego();
    }
}

