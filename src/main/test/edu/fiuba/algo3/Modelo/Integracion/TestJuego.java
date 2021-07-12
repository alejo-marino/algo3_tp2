package edu.fiuba.algo3.Modelo.Integracion;

import edu.fiuba.algo3.Modelo.Juego;
import edu.fiuba.algo3.Modelo.Pais;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.excepciones.CantidadErroneaDeJugadoresError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

public class TestJuego {
    @Test
    public void test01CreoUnJuegoYNoEsNull(){
        Juego juego = new Juego();
        assertNotNull(juego);
    }

    @Test
    public void test02CreoUnJuegoYLeAsigno3JugadoresYTiene3Jugadores(){


        Juego juego = new Juego();
        juego.agregarJugadores(3);

        assertEquals(juego.obtenerCantidadJugadores(), 3);
    }

    @Test
    public void test03CreoUnJuegoYLeAsigno1JugadoresYLaCantidadNoEsValida(){
        Juego juego = new Juego();
        String mensajeError = "";
        try {
            juego.agregarJugadores(1);
        }catch (CantidadErroneaDeJugadoresError error) {
            mensajeError = error.getMessage();
        }
        assertEquals("El numero de jugadores debe estar entre 2-6",mensajeError);
    }

    @Test
    public void test04CreoUnJuegoYLeAsigno7JugadoresYLaCantidadNoEsValida(){
        Juego juego = new Juego();
        String mensajeError = "";
        try {
            juego.agregarJugadores(7);
        }catch (CantidadErroneaDeJugadoresError error) {
            mensajeError = error.getMessage();
        }
        assertEquals("El numero de jugadores debe estar entre 2-6",mensajeError);
    }

    @Test
    public void test05CreoUnJuegoYLeAsigno6JugadoresYLaCantidadEsValida(){
        Juego juego = new Juego();
        juego.agregarJugadores(6);
        assertEquals(juego.obtenerCantidadJugadores(), 6);
    }

    @Test
    public void test06CreoUnJuegoYLeAsigno300JugadoresYLaCantidadNoEsValida(){
        Juego juego = new Juego();
        String mensajeError = "";
        try {
            juego.agregarJugadores(300);
        }catch (CantidadErroneaDeJugadoresError error) {
            mensajeError = error.getMessage();
        }
        assertEquals("El numero de jugadores debe estar entre 2-6",mensajeError);
    }

    @Test
    public void test07CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienenDueño(){
        Juego juego = new Juego();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("ee7733");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();
        assertEquals(tablero.cantidadPaisesOcupados(), 4);
    }

    @Test
    public void test08CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienen1Ejercito(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("ee7733");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);

        Tablero tablero = juego.obtenerTablero();
        Dictionary<String, Pais> listaPaisesOcupados = juego.obtenerPaises();
        Enumeration enumeration = listaPaisesOcupados.keys();
        boolean cantidadEjercitosIncorrecta = true;
        while (enumeration.hasMoreElements()){
            Pais pais = listaPaisesOcupados.get(enumeration.nextElement());
            if (pais.cantidadEjercitos() != 1){
                cantidadEjercitosIncorrecta = false;
            }
        }
        assertTrue(cantidadEjercitosIncorrecta);
    }

    @Test
    public void test09CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");

        Dictionary<String, Integer> paisesJugadores = new Hashtable<>();
        paisesJugadores.put("077bb", 0);
        paisesJugadores.put("cc3311", 0);

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();

        Dictionary<String, Pais> paises = juego.obtenerPaises();

        Enumeration enumeration = paises.keys();

        while (enumeration.hasMoreElements()) {
            Pais pais = paises.get(enumeration.nextElement());
            String jugador = pais.getPaisOcupadoPor();
            Integer cantidadPaises = paisesJugadores.get(jugador);
            cantidadPaises++;
            paisesJugadores.put(jugador, cantidadPaises);
        }

        Enumeration paisesDeJugador = paisesJugadores.keys();
        boolean jugadoresTienen2Paises = true;
        while (paisesDeJugador.hasMoreElements()) {
            if (paisesJugadores.get(paisesDeJugador.nextElement()) != 2) {
                jugadoresTienen2Paises = false;
            }
        }
        assertTrue(jugadoresTienen2Paises);
    }

    @Test
    public void test10CreoUnJuegoYLeAsigno3JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("cfdc3311");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");
        listaPaises.add("Chilesss");
        listaPaises.add("Uruguawewy");

        Dictionary<String, Integer> paisesJugadores = new Hashtable<>();
        paisesJugadores.put("077bb", 0);
        paisesJugadores.put("cc3311", 0);
        paisesJugadores.put("cfdc3311", 0);

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();

        Dictionary<String, Pais> paises = juego.obtenerPaises();

        Enumeration enumeration = paises.keys();

        while (enumeration.hasMoreElements()) {
            Pais pais = paises.get(enumeration.nextElement());
            String jugador = pais.getPaisOcupadoPor();
            Integer cantidadPaises = paisesJugadores.get(jugador);
            cantidadPaises++;
            paisesJugadores.put(jugador, cantidadPaises);
        }

        Enumeration paisesDeJugador = paisesJugadores.keys();
        boolean jugadoresTienen3Paises = true;
        while (paisesDeJugador.hasMoreElements()) {
            if (paisesJugadores.get(paisesDeJugador.nextElement()) != 2) {
                jugadoresTienen3Paises = false;
            }
        }
        assertTrue(jugadoresTienen3Paises);
    }

    @Test
    public void test11CreoUnJuegoYLeAsigno4JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("cfdc3311");
        listaJugadores.add("cfdc33fwefwe11");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");

        Dictionary<String, Integer> paisesJugadores = new Hashtable<>();
        paisesJugadores.put("077bb", 0);
        paisesJugadores.put("cc3311", 0);
        paisesJugadores.put("cfdc3311", 0);
        paisesJugadores.put("cfdc33fwefwe11", 0);

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();

        Dictionary<String, Pais> paises = juego.obtenerPaises();

        Enumeration enumeration = paises.keys();

        while (enumeration.hasMoreElements()) {
            Pais pais = paises.get(enumeration.nextElement());
            String jugador = pais.getPaisOcupadoPor();
            Integer cantidadPaises = paisesJugadores.get(jugador);
            cantidadPaises++;
            paisesJugadores.put(jugador, cantidadPaises);
        }

        Enumeration paisesDeJugador = paisesJugadores.keys();
        boolean jugadoresTienen4Paises = true;
        while (paisesDeJugador.hasMoreElements()) {
            if (paisesJugadores.get(paisesDeJugador.nextElement()) != 1) {
                jugadoresTienen4Paises = false;
            }
        }
        assertTrue(jugadoresTienen4Paises);
    }

    @Test
    public void test12CreoUnJuegoYLeAsigno5JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("cfdc3311");
        listaJugadores.add("cfdc33fwefwe11");
        listaJugadores.add("wefw");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");
        listaPaises.add("Brasil");

        Dictionary<String, Integer> paisesJugadores = new Hashtable<>();
        paisesJugadores.put("077bb", 0);
        paisesJugadores.put("cc3311", 0);
        paisesJugadores.put("cfdc3311", 0);
        paisesJugadores.put("cfdc33fwefwe11", 0);
        paisesJugadores.put("wefw", 0);

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();

        Dictionary<String, Pais> paises = juego.obtenerPaises();

        Enumeration enumeration = paises.keys();

        while (enumeration.hasMoreElements()) {
            Pais pais = paises.get(enumeration.nextElement());
            String jugador = pais.getPaisOcupadoPor();
            Integer cantidadPaises = paisesJugadores.get(jugador);
            cantidadPaises++;
            paisesJugadores.put(jugador, cantidadPaises);
        }

        Enumeration paisesDeJugador = paisesJugadores.keys();
        boolean jugadoresTienen5Paises = true;
        while (paisesDeJugador.hasMoreElements()) {
            if (paisesJugadores.get(paisesDeJugador.nextElement()) != 1) {
                jugadoresTienen5Paises = false;
            }
        }
        assertTrue(jugadoresTienen5Paises);
    }

    @Test
    public void test13CreoUnJuegoYLeAsigno6JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente(){
        Juego juego = new Juego();

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("077bb");
        listaJugadores.add("cc3311");
        listaJugadores.add("cfdc3311");
        listaJugadores.add("cfdc33fwefwe11");
        listaJugadores.add("wefw");
        listaJugadores.add("fwef");

        ArrayList<String> listaPaises = new ArrayList<>();
        listaPaises.add("Argentina");
        listaPaises.add("Paris");
        listaPaises.add("Chile");
        listaPaises.add("Uruguay");
        listaPaises.add("Brasil");
        listaPaises.add("USA");

        Dictionary<String, Integer> paisesJugadores = new Hashtable<>();
        paisesJugadores.put("077bb", 0);
        paisesJugadores.put("cc3311", 0);
        paisesJugadores.put("cfdc3311", 0);
        paisesJugadores.put("cfdc33fwefwe11", 0);
        paisesJugadores.put("wefw", 0);
        paisesJugadores.put("fwef", 0);

        juego.agregarJugadores(6);
        juego.asignarJugadores(listaJugadores);
        juego.inicializarJuego(listaPaises);
        Tablero tablero = juego.obtenerTablero();

        Dictionary<String, Pais> paises = juego.obtenerPaises();

        Enumeration enumeration = paises.keys();

        while (enumeration.hasMoreElements()) {
            Pais pais = paises.get(enumeration.nextElement());
            String jugador = pais.getPaisOcupadoPor();
            Integer cantidadPaises = paisesJugadores.get(jugador);
            cantidadPaises++;
            paisesJugadores.put(jugador, cantidadPaises);
        }

        Enumeration paisesDeJugador = paisesJugadores.keys();
        boolean jugadoresTienen5Paises = true;
        while (paisesDeJugador.hasMoreElements()) {
            if (paisesJugadores.get(paisesDeJugador.nextElement()) != 1) {
                jugadoresTienen5Paises = false;
            }
        }
        assertTrue(jugadoresTienen5Paises);
    }
/*
    @Test
    public void test14CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneEjercitosEnUnPaisAjeno (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(ReforzarPaisAjenoException.class, () -> jugador1.reforzar(listaDePaisesJug2[0], 3));
    }

    @Test
    public void test15CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneMasEjercitosDeLosQuePuedeEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(CantidadAReforzarInvalidaException.class, () -> jugador1.reforzar(listaDePaisesJug1[0], 6));
    }

    @Test
    public void test16CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneMasEjercitosDeLosQuePuedeEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(CantidadAReforzarInvalidaException.class, () -> jugador1.reforzar(listaDePaisesJug1[0], 6));
    }

    @Test
    public void test17CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1Pone3EjercitosEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        jugador1.reforzar(listaDePaisesJug1[0], 3);

        assertEquals(listaDePaisesJug1[0].cantidadEjercitos(), 4)
    }

    @Test
    public void test18CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1IntentaAtacarConUnPaisQueNoEsSuyo (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = juego.getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais paisAtacante = listaDePaisesJug1[0];
        List listaLimitrofesAtacante = paisAtacante.getLimitrofesAjenos();
        Pais paisDefensor = listaLimitrofesAtacante[0];

        paisAtacante.reforzar(3);
        paisDefensor.reforzar(3);

        assertThrows(AtaqueConPaisAjenoException.class, () -> jugador1.atacar(listaDePaisesJug2[0], listaDePaisesJug2[1]));
    }

    @Test
    public void test19CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1Ataca (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

    }

    @Test
    public void test20Jugador1AtacaUnPaisConquistadoPorElMismo (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = jugador1.getPaisesJugador();
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = jugador2.getPaisesJugador();

        Pais paisAtacante = listaDePaisesJug1[0];
        paisAtacante.reforzar(3)
        List listaAdyacentesPropios = paisAtacante.getLimitrofesPropios();
        Pais paisDefensor = listaAdyacentesPropios[0];

        assertThrows(AtaqueAUnPaisPropioException.class, () -> jugador1.atacar(paisAtacante, paisDefensor));
    }

    @Test
    public void test2xJugador1AtacaUnPaisAjenoPeroNoLimitrofe (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais pais = listaDePaisesJug1[0];
        List limitrofes = pais.getLimitrofes();



    }

    @Test
    public void test2xJugador1AtacaUnPaisAjenoPeroNoTieneSuficientesEjercitos (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais paisAtacante = listaDePaisesJug1[0];
        List listaLimitrofesAtacante = paisAtacante.getLimitrofesAjenos();
        Pais paisDefensor = listaLimitrofesAtacante[0];
        assertTrue()
    }
*/
}

