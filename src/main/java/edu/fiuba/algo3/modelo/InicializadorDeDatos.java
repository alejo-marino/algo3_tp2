package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Continente;

public class InicializadorDeDatos {
    /*
    Juego, a la hora de juego.inicializarJuego(), llamara primero a ParserTEG con los archivos .json, y los datos que
    devuelva ParserTEG, lo recibira esta clase, creara los objetos pertenecientes al juego con dichos datos para que
    Juego pueda inicializar Tablero con los correspondientes Objetos.
    */

    /* Comente esta funcion porque creo que es mas conveniente que juego llame a cada una de las funciones individualmente
    (no puedo retornar la listaCartas y diccionarioPaises ambas desde la misma funcion a no ser que me ponga a crear una lista)
    public void inicializarDatos(Hashtable<String, String[]> diccPaises, Hashtable<String, ArrayList> diccContinentes, ArrayList<ArrayList> listaCartas) {
        inicializarContinentesYPaises(diccPaises, diccContinentes);
        inicializarCartas(listaCartas);
    }*/

    /* falta implementar en esta funcion el algoritmo que reparta los paises equitativamente dependiendo de la cantidad de Jugadores
    la primera pasada de inicializarContinentesYPaises va a crear solo los paises y meterlos a cada uno en su continente
    correspondiente, luego a esa lista de paises, le aplicare el algoritmos de distribucion equitativa de paises entre jugadores,
    en la segunda pasada, cuando ya todos los paises conozcan a su duenio, recien ahi podre asignar a cada pais los limitrofes que les correspondan.
     */


    private final Integer BONUS_AMERICA_DEL_SUR = 3;
    private final Integer BONUS_AFRICA = 3;
    private final Integer BONUS_OCEANIA = 2;
    private final Integer BONUS_AMERICA_DEL_NORTE = 5;
    private final Integer BONUS_EUROPA = 5;
    private final Integer BONUS_ASIA = 7;


    Hashtable<String, Integer> diccBonusContinentes;

    public InicializadorDeDatos () {
        diccBonusContinentes = crearDiccBonusContinentes();
    }

    private Hashtable<String, Integer> crearDiccBonusContinentes() {
        Hashtable <String, Integer> diccBonusContinentes = new Hashtable();
        diccBonusContinentes.put("America Del Sur", BONUS_AMERICA_DEL_SUR);
        diccBonusContinentes.put("America Del Norte", BONUS_AMERICA_DEL_NORTE);
        diccBonusContinentes.put("Oceania", BONUS_OCEANIA);
        diccBonusContinentes.put("Asia", BONUS_ASIA);
        diccBonusContinentes.put("Europa", BONUS_EUROPA);
        diccBonusContinentes.put("Africa", BONUS_AFRICA);
        return diccBonusContinentes;
    }


    public Tablero inicializarContinentesYPaises(Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes, Queue<Jugador> jugadores) {
        ArrayList<Continente> listaContinentes = new ArrayList<Continente>();
        ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            Continente continente = new Continente(nombreContinente, diccBonusContinentes.get(nombreContinente));
            listaContinentes.add(continente);
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                Jugador jugadorActual = jugadores.remove();
                Pais pais = new Pais(nombrePais, jugadorActual); // este nombreJugador es un placeholder para cuando tengamos el algoritmo de distribucion de paises seria bueno inicializar con un jugador NULL y luego de la primera pasada pisar el duenio del pais con el que corresponda
                listaPaises.add(pais);
                continente.agregarPais(pais);
                jugadores.add(jugadorActual);
            });
        });

        // segunda pasada: agrego limitrofes
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                listaPaisesLimitrofes.forEach((nombrePaisLimitrofe) -> {
                    for (Pais paisAChequearSiEsLimitrofe: listaPaises) {
                        if ((paisAChequearSiEsLimitrofe.toString()).equals(nombrePaisLimitrofe)) {
                            Pais paisLimitrofe = getPais(listaPaises, nombrePaisLimitrofe);
                            paisAChequearSiEsLimitrofe.hacerLimitrofe(paisLimitrofe);
                        }
                    }
                });
            });
        });

        Tablero tablero = new Tablero(listaPaises, listaContinentes);
        return tablero;
    }

    public ArrayList<Tarjeta> inicializarTarjetas(ArrayList<ArrayList<String>> tarjetas, ArrayList<Pais> paises) {
        ArrayList<Tarjeta> tarjetasADevolver = new ArrayList();
        for (ArrayList<String> tuplaTarjeta: tarjetas) {
            String nombrePais = tuplaTarjeta.get(0);
            Pais objetoPais = getPais(paises, nombrePais);
            String simboloTarjeta = tuplaTarjeta.get(1);
            Tarjeta tarjeta = new Tarjeta(objetoPais, simboloTarjeta);
            tarjetasADevolver.add(tarjeta);
        }
        return tarjetasADevolver;
    }

    private Pais getPais(ArrayList<Pais> paises, String nombrePais) {
        return paises.stream().filter(pais -> nombrePais.equals(pais.toString())).findFirst().orElse(null);
    }

    //return listCarnet.stream().filter(carnet -> codeIsIn.equals(carnet.getCodeIsin())).findFirst().orElse(null);
    //return listaPaises.stream().filter(pais -> paisAChequearSiEsLimitrofe.equals(pais.toString())).findFirst().orElse(null);
}