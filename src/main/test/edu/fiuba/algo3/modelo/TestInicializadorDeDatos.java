package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestInicializadorDeDatos {

    // Paths.get("JSON/", "Fronteras.json")
    private String RUTA_JSON_FRONTERAS = "src/main/java/edu/fiuba/algo3/modelo/JSON/Fronteras.json";
    private String RUTA_JSON_TARJETAS = "src/main/java/edu/fiuba/algo3/modelo/JSON/Cartas.json";
    private InicializadorDeDatos inicializador;
    private ArrayList<Jugador> jugadores;
    private Hashtable<String, Hashtable<String, ArrayList<String>>> paisesParseados;
    private ArrayList<ArrayList<String>> tarjetasParseadas;

    @BeforeEach
    void setUp() {
        ParserTEG parser = new ParserTEG();
        String rutaCartas = new File(RUTA_JSON_TARJETAS).getAbsolutePath();
        String rutaFronteras = new File(RUTA_JSON_FRONTERAS).getAbsolutePath();
        ArrayList aux = parser.parsearTablero(rutaFronteras, rutaCartas);
        this.paisesParseados = (Hashtable<String, Hashtable<String, ArrayList<String>>>) aux.get(0);
        this.tarjetasParseadas = (ArrayList<ArrayList<String>>) aux.get(1);
        this.inicializador = new InicializadorDeDatos();
        this.jugadores = new ArrayList<>();
        jugadores.add(new Jugador("000000"));
        jugadores.add(new Jugador("ffffff"));
    }

    @Test
    public void test01CreoUnInicializadorDeDatosYNoEsNull () {
        assertNotNull(inicializador);
    }

    @Test
    public void test02CreoUnInicializadorDeDatosYVerificoQueElTableroCreadoPosea50Paises () {
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        assertEquals(50, tablero.size());
    }

    @Test
    public void test03CreoUnInicializadorDeDatosCon2JugadoresYVerificoQueCadaJugadorTiene25Paises () {
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Integer cantidadPaisesJugador1 = paisesPorJugador.get(jugador1).size();
        Integer cantidadPaisesJugador2 = paisesPorJugador.get(jugador2).size();

        assertEquals(25, cantidadPaisesJugador1);
        assertEquals(25, cantidadPaisesJugador2);
    }

    @Test
    public void test04CreoUnInicializadorDeDatosCon3JugadoresY2JugadoresTienen17PaisesY1Tiene16 () {
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Jugador jugador3 = new Jugador("fff000");
        jugadores.add(jugador3);
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        Integer cantidadPaisesJugador1 = paisesPorJugador.get(jugador1).size();
        Integer cantidadPaisesJugador2 = paisesPorJugador.get(jugador2).size();
        Integer cantidadPaisesJugador3 = paisesPorJugador.get(jugador3).size();

        assertEquals(17, cantidadPaisesJugador1);
        assertEquals(17, cantidadPaisesJugador2);
        assertEquals(16, cantidadPaisesJugador3);
    }

    @Test
    public void test05CreoUnInicializadorDeDatosCon4JugadoresY2JugadoresTienen13PaisesY2Tienen12 () {
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Jugador jugador3 = new Jugador("fff000");
        Jugador jugador4 = new Jugador("ffff00");
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        Integer cantidadPaisesJugador1 = paisesPorJugador.get(jugador1).size();
        Integer cantidadPaisesJugador2 = paisesPorJugador.get(jugador2).size();
        Integer cantidadPaisesJugador3 = paisesPorJugador.get(jugador3).size();
        Integer cantidadPaisesJugador4 = paisesPorJugador.get(jugador4).size();

        assertEquals(13, cantidadPaisesJugador1);
        assertEquals(13, cantidadPaisesJugador2);
        assertEquals(12, cantidadPaisesJugador3);
        assertEquals(12, cantidadPaisesJugador4);
    }

    @Test
    public void test06CreoUnInicializadorDeDatosCon5JugadoresYCadaJugadorTiene10Paises () {
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Jugador jugador3 = new Jugador("fff000");
        Jugador jugador4 = new Jugador("ffff00");
        Jugador jugador5 = new Jugador("ffff00");
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        Integer cantidadPaisesJugador1 = paisesPorJugador.get(jugador1).size();
        Integer cantidadPaisesJugador2 = paisesPorJugador.get(jugador2).size();
        Integer cantidadPaisesJugador3 = paisesPorJugador.get(jugador3).size();
        Integer cantidadPaisesJugador4 = paisesPorJugador.get(jugador4).size();
        Integer cantidadPaisesJugador5 = paisesPorJugador.get(jugador5).size();

        assertEquals(10, cantidadPaisesJugador1);
        assertEquals(10, cantidadPaisesJugador2);
        assertEquals(10, cantidadPaisesJugador3);
        assertEquals(10, cantidadPaisesJugador4);
        assertEquals(10, cantidadPaisesJugador5);
    }

    @Test
    public void test07CreoUnInicializadorDeDatosCon6JugadoresY2JugadoresTienen9PaisesY4Tienen8 () {
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Jugador jugador3 = new Jugador("fff000");
        Jugador jugador4 = new Jugador("ffff00");
        Jugador jugador5 = new Jugador("f00s00");
        Jugador jugador6 = new Jugador("123456");
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));
        Dictionary<Jugador, ArrayList<Pais>> paisesPorJugador = tablero.obtenerPaisesSegunJugador();

        Integer cantidadPaisesJugador1 = paisesPorJugador.get(jugador1).size();
        Integer cantidadPaisesJugador2 = paisesPorJugador.get(jugador2).size();
        Integer cantidadPaisesJugador3 = paisesPorJugador.get(jugador3).size();
        Integer cantidadPaisesJugador4 = paisesPorJugador.get(jugador4).size();
        Integer cantidadPaisesJugador5 = paisesPorJugador.get(jugador5).size();
        Integer cantidadPaisesJugador6 = paisesPorJugador.get(jugador6).size();

        assertEquals(9, cantidadPaisesJugador1);
        assertEquals(9, cantidadPaisesJugador2);
        assertEquals(8, cantidadPaisesJugador3);
        assertEquals(8, cantidadPaisesJugador4);
        assertEquals(8, cantidadPaisesJugador5);
        assertEquals(8, cantidadPaisesJugador6);
    }

    @Test
    public void test08CreoTodosLosPaisesYArgentinaExiste () {
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));

        Pais argentina = tablero.seleccionarPais("Argentina");

        assertEquals("Argentina", argentina.toString());
    }

    @Test
    public void test09CreoTodosLosPaisesYArgentinaTiene1SoloDuenio () {
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        Tablero tablero = new Tablero(aux.get(0), aux.get(1));

        Pais argentina = tablero.seleccionarPais("Argentina");
        Integer cantidadDuenios = 0;
        for (Jugador jugador: jugadores) {
            if (argentina.esDuenio(jugador)) {
                cantidadDuenios++;
            }
        }

        assertEquals(1, cantidadDuenios);
    }

    @Test
    public void test10CreoTodosLosPaisesYTodosTienen1SoloDuenio () {
        ArrayList<ArrayList> aux = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        ArrayList<Pais> listaPaises = aux.get(0);

        boolean tienen1Duenio = true;
        for (Pais pais: listaPaises) {
            Integer cantidadDuenios = 0;
            for (Jugador jugador: jugadores) {
                if (pais.esDuenio(jugador)) {
                    cantidadDuenios++;
                }
            }
            if (cantidadDuenios != 1) {
                tienen1Duenio = false;
                break;
            }
        }

        assertTrue(tienen1Duenio);
    }


    @Test
    public void test11CreoTarjetasYHay50 () {
        ArrayList<ArrayList> listaPaises = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);

        ArrayList<Tarjeta> tarjetas = this.inicializador.inicializarTarjetas(tarjetasParseadas, listaPaises.get(0));

        assertEquals(50, tarjetas.size());
    }

    @Test
    public void test12CreoTarjetasYHayLaCantidadCorrectaDeSimbolos () {
        ArrayList<ArrayList> listaPaises = this.inicializador.inicializarContinentesYPaises(paisesParseados, jugadores);
        ArrayList<Tarjeta> tarjetas = this.inicializador.inicializarTarjetas(tarjetasParseadas, listaPaises.get(0));

        Integer cantidadComodinesEsperada = 2;
        Integer cantidadGlobosEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer cantidadCanionesEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer cantidadBarcosEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer contadorGlobos = 0;
        Integer contadorCaniones = 0;
        Integer contadorBarcos = 0;
        Integer contadorComodines = 0;

        for (Tarjeta tarjeta: tarjetas) {
            switch (tarjeta.getSimbolo()) {
                case "Globo":
                    contadorGlobos++;
                    break;
                case "Cañon":
                    contadorCaniones++;
                    break;
                case "Barco":
                    contadorBarcos++;
                    break;
                case "Comodin":
                    contadorComodines++;
            }
        }

        assertEquals(cantidadGlobosEsperada, contadorGlobos);
        assertEquals(cantidadCanionesEsperada, contadorCaniones);
        assertEquals(cantidadBarcosEsperada, contadorBarcos);
        assertEquals(cantidadComodinesEsperada, contadorComodines);
    }

}
