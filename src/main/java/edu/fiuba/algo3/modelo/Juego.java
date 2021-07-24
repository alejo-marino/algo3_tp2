package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresNoAsignadoException;

import java.lang.reflect.Array;
import java.util.*;


public class Juego {

    private final String rutaJsonFronteras = "src/main/java/edu/fiuba/algo3/modelo/JSON/Fronteras.json";
    private final String rutaJsonTarjetas = "src/main/java/edu/fiuba/algo3/modelo/JSON/Cartas.json";
    private final Queue<String> colores;

    private Tablero tablero;
    private SistemaDeTurnos sistemaTurnos;
    private ArrayList<Jugador> listaJugadores;
    private Queue<Tarjeta> mazoDeCartas;

    private static Juego instancia = new Juego();

    private Juego() {
        this.colores = new LinkedList<>();
        this.colores.add("077bb");  // azul
        this.colores.add("cc3311");  // rojo
        this.colores.add("ee7733");  // amarillo
        this.colores.add("009988");  // verde
        this.colores.add("ee3377");  // rosa
        this.colores.add("000000");  // negro
    }

    public static Juego getInstancia() {
        return instancia;
    }

    public void setearCantidadJugadores(Integer numeroJugadores) {
        if (numeroJugadores < 2 || numeroJugadores > 6) {
            throw new NumeroDeJugadoresInvalidoException();
        }
        this.listaJugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            String color = colores.remove();
            colores.add(color);
            listaJugadores.add(new Jugador(color));
        }
    }

    /* esta funcion seria un setting que permite modificar la cantidad de rondas iniciales y los refuerzos disponibles en cada una de ellas
    ya que no era un requerimiento de la consigna, simplemente la hardcodeamos con {5, 3}, pero podria recibir por parametros el numero
    de rondas y la cantidad en cada una de ellas.
    */
    private Queue<Integer> setearRondasIniciales() {
        Queue<Integer> colaDeNumerosDeRefuerzoPorRonda = new LinkedList<>();
        colaDeNumerosDeRefuerzoPorRonda.add(5);
        colaDeNumerosDeRefuerzoPorRonda.add(3);
        return colaDeNumerosDeRefuerzoPorRonda;
    }

    public SistemaDeTurnos iniciarJuego() {
        if (listaJugadores == null)
            throw new NumeroDeJugadoresNoAsignadoException();

        ParserTEG parser = new ParserTEG();
        ArrayList aux = parser.parsearTablero(rutaJsonFronteras, rutaJsonTarjetas);
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccionarioPaisesParseados = (Hashtable<String, Hashtable<String, ArrayList<String>>>) aux.get(0);
        ArrayList<ArrayList<String>> listaTarjetasParseadas = (ArrayList<ArrayList<String>>) aux.get(1);
        InicializadorDeDatos inicializador = new InicializadorDeDatos();
        ArrayList<ArrayList> aux2 = inicializador.inicializarContinentesYPaises(diccionarioPaisesParseados, listaJugadores);
        ArrayList<Pais> listaPaises = aux2.get(0);
        ArrayList<Continente> listaContinente = aux2.get(1);
        this.tablero = new Tablero(listaPaises, listaContinente);
        ArrayList<Tarjeta> listaTarjetas = inicializador.inicializarTarjetas(listaTarjetasParseadas, listaPaises);
        this.mazoDeCartas = this.convertirListaDeTarjetasACola(listaTarjetas);
        // iniciarMisionesYDistribuirlas();

        SistemaDeTurnos sistemaDeTurnos = new SistemaDeTurnos(listaJugadores, this, this.setearRondasIniciales());
        return sistemaDeTurnos;
    }

    private Queue<Tarjeta> convertirListaDeTarjetasACola(ArrayList<Tarjeta> tarjetas) {
        Queue<Tarjeta> colaTarjetas = new LinkedList<>();
        for (Tarjeta tarjeta: tarjetas) {
            colaTarjetas.add(tarjeta);
        }
        return colaTarjetas;
    }

    public Pais seleccionarPais(String nombrePais) {
        return this.tablero.seleccionarPais(nombrePais);
    }


    public Integer calcularEjercitosDisponibles(Jugador jugador) {
        return this.tablero.calcularEjercitosDisponibles(jugador);
    }
}
