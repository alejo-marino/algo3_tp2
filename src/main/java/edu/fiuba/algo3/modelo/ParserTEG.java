package edu.fiuba.algo3.modelo;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;


public class ParserTEG {

    public ArrayList parsearTablero(String rutaArchivoFronteras, String rutaArchivoTarjetas) {
        ArrayList datosADevolver = new ArrayList();
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes = this.obtenerDiccionariosPaisesYContinentes(rutaArchivoFronteras);
        ArrayList<ArrayList<String>> listaTarjetas = this.obtenerDiccionarioTarjetas(rutaArchivoTarjetas);
        datosADevolver.add(diccContinentes);
        datosADevolver.add(listaTarjetas);
        return datosADevolver;
    }

    private void parsearPais(JSONObject paisJSON, Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes) {
        String nombrePais = (String) paisJSON.get("Pais");
        String nombreContinente = (String) paisJSON.get("Continente");
        String[] stringLimitrofes = ((String)paisJSON.get("Limita con")).split(",");
        ArrayList<String> listaLimitrofes = new ArrayList(Arrays.asList(stringLimitrofes));

        if (!(diccContinentes.containsKey(nombreContinente))) {
            Hashtable<String, ArrayList<String>> diccPaisesEnContinente = new Hashtable<String, ArrayList<String>>();
            diccContinentes.put(nombreContinente, diccPaisesEnContinente);
        }
        /* diccContinentes.get(nombreContinente) devuelve el diccionario con claves paises que estan en el continente
        y valores, un array de strings con los paises limitrofes del pais */
        (diccContinentes.get(nombreContinente)).put(nombrePais, listaLimitrofes);
    }

    private Hashtable<String, Hashtable<String, ArrayList<String>>> obtenerDiccionariosPaisesYContinentes(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes = new Hashtable<String, Hashtable<String, ArrayList<String>>>();

        try (FileReader reader = new FileReader(rutaArchivo)) {

            JSONArray paisesJSON = (JSONArray) parser.parse(reader);
            paisesJSON.forEach(pais -> parsearPais((JSONObject) pais, diccContinentes));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return diccContinentes;
    }

    // TARJETAS

    private void parsearTarjeta(JSONObject tarjetaJSON, ArrayList<ArrayList<String>> listaTarjetas) {
        String nombrePais = (String) tarjetaJSON.get("Pais");
        String nombreTarjeta = (String) tarjetaJSON.get("Simbolo");
        ArrayList<String> arrayTarjeta = new ArrayList<>();
        arrayTarjeta.add(nombrePais);
        arrayTarjeta.add(nombreTarjeta);
        listaTarjetas.add(arrayTarjeta);
    }

    private ArrayList<ArrayList<String>> obtenerDiccionarioTarjetas(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        ArrayList<ArrayList<String>> listaTarjetas = new ArrayList<ArrayList<String>>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            JSONArray tarjetasJSON = (JSONArray) parser.parse(reader);
            tarjetasJSON.forEach(pais -> parsearTarjeta((JSONObject) pais, listaTarjetas));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return listaTarjetas;
    }

    // MISIONES

    public Hashtable<String, ArrayList> parsearMisiones(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        Hashtable<String, ArrayList> diccMisiones = new Hashtable<>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            JSONArray tiposMisionesJSON = (JSONArray) parser.parse(reader);
            JSONObject tiposMisionesJSONObject = (JSONObject) tiposMisionesJSON.get(0);

            diccMisiones.put("Conquista", this.parsearMisionesConquista((JSONArray) tiposMisionesJSONObject.get("Conquista")));
            diccMisiones.put("Destruccion", this.parsearMisionesDestruccion((JSONArray) tiposMisionesJSONObject.get("Destruccion")));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return diccMisiones;
    }

    private ArrayList<Hashtable<String, String>> parsearMisionesConquista(JSONArray arrayMisionesJSON) {
        // Array que contiene distintos arrays que representan misiones
        ArrayList<Hashtable<String, String>> misionesConquista = new ArrayList<>();
        arrayMisionesJSON.forEach(mision -> parsearMisionConquista((JSONArray) mision, misionesConquista));
        return misionesConquista;
    }

    private void parsearMisionConquista (JSONArray misionJSON, ArrayList<Hashtable<String, String>> misionesConquista) {
        Hashtable<String, String> mision = new Hashtable<>();
        misionJSON.forEach(condicion ->  parsearCondicionConquista( (JSONObject) condicion, mision));
        misionesConquista.add(mision);
    }

    private void parsearCondicionConquista(JSONObject condicion, Hashtable<String, String> mision) {
        String continente = (String) condicion.get("continente");
        String cantPaises = (String) condicion.get("paises");
        mision.put(continente, cantPaises);
    }

    private ArrayList<ArrayList<String>> parsearMisionesDestruccion(JSONArray arrayMisionesJSON) {
        ArrayList<ArrayList<String>> misionesDestruccion = new ArrayList<>();
        arrayMisionesJSON.forEach(mision -> parsearMisionDestruccion((JSONArray) mision, misionesDestruccion));
        return misionesDestruccion;
    }

    private void parsearMisionDestruccion (JSONArray misionJSON, ArrayList<ArrayList<String>> misionesDestruccion) {
        ArrayList<String> mision = new ArrayList<>();
        misionJSON.forEach(condicion ->  parsearCondicionDestruccion( (JSONObject) condicion, mision));
        misionesDestruccion.add(mision);
    }

    private void parsearCondicionDestruccion(JSONObject condicion, ArrayList<String> mision) {
        String enemigo = (String) condicion.get("enemigo");
        mision.add(enemigo);
    }

}