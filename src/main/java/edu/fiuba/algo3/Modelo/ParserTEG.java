package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.ArchivoNoEncontradoException;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ParserTEG {

    public ArrayList parsearTablero(String rutaArchivo) {
        ArrayList datosADevolver = new ArrayList();
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes = this.obtenerDiccionariosPaisesYContinentes(rutaArchivo);
        ArrayList<ArrayList<String>> listaCartas = this.obtenerDiccionarioCartas(rutaArchivo);
        datosADevolver.add(diccContinentes);
        datosADevolver.add(listaCartas);
        return datosADevolver;
    }

    private void parsearPais(JSONObject paisJSON, Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes) {
        String nombrePais = (String) paisJSON.get("Pais");
        String nombreContinente = (String) paisJSON.get("Continente");
        ArrayList<String> stringLimitrofes = (paisJSON.get("Limita Con")).split(",");
        ArrayList<String> listaLimitrofes = new ArrayList(Arrays.asList(stringLimitrofes));

        if (!(diccContinentes.containsKey(nombreContinente))) {
            Hashtable<String, ArrayList<String>> diccPaisesEnContinente = new Hashtable<String, ArrayList<String>>();
            diccContinentes.put(nombreContinente, diccPaisesEnContinente);
        }
        /* diccContinentes.get(nombreContinente) devuelve el diccionario con claves paises que estan en el continente
        y valores, un array de strings con los paises limitrofes del pais */
        (diccContinentes.get(nombreContinente)).put(nombrePais, listaLimitrofes);
    }

    private void parsearCarta(JSONObject cartasJSON, ArrayList<ArrayList<String>> listaCartas) {
        String nombrePais = (String) paisJSON.get("Pais");
        String nombreCarta = (String) paisJSON.get("Simbolo");
        ArrayList<String> arrayCarta = new ArrayList<String>();
        arrayCarta.add(nombrePais);
        arrayCarta.add(nombreCarta);
        listaCartas.add(arrayCarta);
    }

    private Hashtable<String, Hashtable<String, ArrayList<String>>> obtenerDiccionariosPaisesYContinentes(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes = new Hashtable<String, Hashtable<String, ArrayList<String>>>();

        try (FileReader reader = new FileReader(rutaArchivo)) {

            Object obj = parser.parse(reader);

            JSONArray paisesJSON = (JSONArray) obj;

            paisesJSON.forEach(pais -> parsearPais((JSONObject) pais, diccContinentes));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diccContinentes;
    }

    private ArrayList<ArrayList<String>> obtenerDiccionarioCartas(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        ArrayList<ArrayList<String>> listaCartas = new ArrayList<ArrayList<String>>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            Object obj = parser.parse(reader);

            JSONArray cartasJSON = (JSONArray) obj;

            cartasJSON.forEach(pais -> parsearCarta((JSONObject) pais, listaCartas));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listaCartas;
    }



}
