package edu.fiuba.algo3.modelo;

import java.util.*;

import static java.lang.Integer.parseInt;
import static edu.fiuba.algo3.modelo.Constantes.*;

public class InicializadorDeDatos {
    /*
    Juego, a la hora de juego.inicializarJuego(), llamara primero a ParserTEG con los archivos .json, y los datos que
    devuelva ParserTEG, lo recibira esta clase, creara los objetos pertenecientes al juego con dichos datos para que
    Juego pueda inicializar Tablero con los correspondientes Objetos.
    */

    /* Comente esta funcion porque creo que es mas conveniente que juego llame a cada una de las funciones individualmente
    (no puedo retornar la listaCartas y diccionarioPaises ambas desde la misma funcion a no ser que me ponga a crear una lista)
    public void inicializarDatos(Hashtable<String, String[]> diccPaises, Hashtable<String, ArrayList> diccContinentes, ArrayList<ArrayList> listaCartas) {
        inicializarDatos(diccPaises, diccContinentes);
        inicializarCartas(listaCartas);
    }*/

    /* falta implementar en esta funcion el algoritmo que reparta los paises equitativamente dependiendo de la cantidad de Jugadores
    la primera pasada de inicializarDatos va a crear solo los paises y meterlos a cada uno en su continente
    correspondiente, luego a esa lista de paises, le aplicare el algoritmos de distribucion equitativa de paises entre jugadores,
    en la segunda pasada, cuando ya todos los paises conozcan a su duenio, recien ahi podre asignar a cada pais los limitrofes que les correspondan.
     */


    Hashtable<String, Integer> diccBonusContinentes;

    public InicializadorDeDatos () {
        diccBonusContinentes = crearDiccBonusContinentes();
    }

    private Hashtable<String, Integer> crearDiccBonusContinentes() {
        Hashtable <String, Integer> diccBonusContinentes = new Hashtable();
        diccBonusContinentes.put("America Del Sur", bonusAmericaDelSur);
        diccBonusContinentes.put("America Del Norte", bonuaAmericaDelNorte );
        diccBonusContinentes.put("Oceania", bonusOceania);
        diccBonusContinentes.put("Asia", bonusAsia);
        diccBonusContinentes.put("Europa", bonusEuropa);
        diccBonusContinentes.put("Africa", bonusAfrica);
        return diccBonusContinentes;
    }


    public Map<String, ArrayList> inicializarDatos(ArrayList<Jugador> jugadores) {
        ParserTEG parser = new ParserTEG();
        ArrayList aux = parser.parsearTablero(rutaJsonFronteras, rutaJsonTarjetas);
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes =
                (Hashtable<String, Hashtable<String, ArrayList<String>>>) aux.get(0);
        ArrayList<ArrayList<String>> tarjetasParseadas = (ArrayList<ArrayList<String>>) aux.get(1);
        Hashtable<String, ArrayList> diccMisionesParseadas = parser.parsearMisiones(rutaJsonMisiones);

        Map<String, ArrayList> paisesYContinentes = inicializarPaisesYContinentes(diccContinentes);
        ArrayList<Pais> listaPaises = paisesYContinentes.get("Paises");
        ArrayList<Continente> listaContinentes = paisesYContinentes.get("Continentes");

        ArrayList<Tarjeta> tarjetas = inicializarTarjetas(tarjetasParseadas, listaPaises);

        ArrayList<Mision> misiones = inicializarMisiones(diccMisionesParseadas, listaContinentes, jugadores);

        Map<String, ArrayList> datosInicializados = new HashMap<>();
        datosInicializados.put("Paises", listaPaises);
        datosInicializados.put("Continentes", listaContinentes);
        datosInicializados.put("Tarjetas", tarjetas);
        datosInicializados.put("Misiones", misiones);

        return datosInicializados;
    }

    private Map<String, ArrayList> inicializarPaisesYContinentes(Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes) {
        ArrayList<Continente> listaContinentes = new ArrayList<>();
        ArrayList<Pais> listaPaises = new ArrayList<>();
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            Continente continente = new Continente(nombreContinente, diccBonusContinentes.get(nombreContinente));
            listaContinentes.add(continente);
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                Pais pais = new Pais(nombrePais);
                listaPaises.add(pais);
                continente.agregarPais(pais);
            });
        });

        agregarLimitrofes(diccContinentes, listaPaises);

        Map<String, ArrayList> resultado = new HashMap<>();
        resultado.put("Continentes", listaContinentes);
        resultado.put("Paises", listaPaises);
        return resultado;
    }

    private void agregarLimitrofes(Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes, ArrayList<Pais> listaPaises) {
        // segunda pasada: agrego limitrofes
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                listaPaisesLimitrofes.forEach((nombrePaisLimitrofe) -> {
                    for (Pais paisAChequearSiEsLimitrofe: listaPaises) {
                        if ((paisAChequearSiEsLimitrofe.toString()).equals(nombrePaisLimitrofe)) {
                            Pais pais = getPais(listaPaises, nombrePais);
                            pais.hacerLimitrofe(paisAChequearSiEsLimitrofe);
                        }
                    }
                });
            });
        });
    }

    private ArrayList<Tarjeta> inicializarTarjetas(ArrayList<ArrayList<String>> tarjetas, ArrayList<Pais> paises) {
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

    private ArrayList<Mision> inicializarMisiones(Hashtable<String, ArrayList> diccMisionesParseadas, ArrayList<Continente> listaContinente, ArrayList<Jugador> listaJugadores) {
        ArrayList<Mision> misiones = new ArrayList<>();
        misiones.addAll(this.inicializarMisionesConquista(diccMisionesParseadas.get("Conquista"), listaContinente));
        misiones.addAll(this.inicializarMisionesDestruccion(diccMisionesParseadas.get("Destruccion"), listaJugadores));

        return misiones;
    }

    private ArrayList<MisionConquista> inicializarMisionesConquista(ArrayList misionesConquistaParseadas, ArrayList<Continente> listaContinente) {
        ArrayList<MisionConquista> misionesConquista = new ArrayList<>();
        misionesConquistaParseadas.forEach(mision -> inicializarMisionConquista((Hashtable<String, String>) mision, misionesConquista, listaContinente));
        return misionesConquista;
    }

    private void inicializarMisionConquista(Hashtable<String, String> diccMision, ArrayList<MisionConquista> misionesConquista, ArrayList<Continente> listaContinente) {
        Map<String, Integer> condiciones = new HashMap<>();
        diccMision.forEach((nombreContinente, cantPaisesString) -> {
            Integer cantPaises = 0;
            if (cantPaisesString.equals("all")) {
                for (Continente continente: listaContinente) {
                    if (continente.toString().equals(nombreContinente)) {
                        cantPaises = continente.size();
                    }
                }
            } else {
                cantPaises = parseInt(cantPaisesString);
            }
            condiciones.put(nombreContinente, cantPaises);
        });
        MisionConquista mision = new MisionConquista(Juego.getInstancia(), condiciones);
        misionesConquista.add(mision);
    }


    private ArrayList<MisionDestruccion> inicializarMisionesDestruccion(ArrayList<ArrayList<String>> misionesDestruccionParseadas, ArrayList<Jugador> jugadores) {
        ArrayList<MisionDestruccion> misionesDestruccion = new ArrayList<>();
        misionesDestruccionParseadas.forEach(mision -> inicializarMisionDestruccion(mision, jugadores, misionesDestruccion));
        return misionesDestruccion;
    }

    private void inicializarMisionDestruccion(ArrayList<String> arrayMision, ArrayList<Jugador> jugadores, ArrayList<MisionDestruccion> misionesDestruccion) {
        String nombreJugadorEnemigo = arrayMision.get(0);
        Jugador jugadorEnemigo = null;
        for (Jugador jugador: jugadores) {
            if (jugador.toString().equals(nombreJugadorEnemigo)) {
                jugadorEnemigo = jugador;
            }
        }

        MisionDestruccion mision = new MisionDestruccion(Juego.getInstancia(), jugadorEnemigo);
        misionesDestruccion.add(mision);
    }


    //return listCarnet.stream().filter(carnet -> codeIsIn.equals(carnet.getCodeIsin())).findFirst().orElse(null);
    //return listaPaises.stream().filter(pais -> paisAChequearSiEsLimitrofe.equals(pais.toString())).findFirst().orElse(null);
}