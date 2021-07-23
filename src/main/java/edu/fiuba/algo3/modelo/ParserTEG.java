package edu.fiuba.algo3.modelo;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
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
        String[] stringLimitrofes = ((String)paisJSON.get("Limita Con")).split(",");
        ArrayList<String> listaLimitrofes = new ArrayList(Arrays.asList(stringLimitrofes));

        if (!(diccContinentes.containsKey(nombreContinente))) {
            Hashtable<String, ArrayList<String>> diccPaisesEnContinente = new Hashtable<String, ArrayList<String>>();
            diccContinentes.put(nombreContinente, diccPaisesEnContinente);
        }
        /* diccContinentes.get(nombreContinente) devuelve el diccionario con claves paises que estan en el continente
        y valores, un array de strings con los paises limitrofes del pais */
        (diccContinentes.get(nombreContinente)).put(nombrePais, listaLimitrofes);
    }

    private void parsearTarjeta(JSONObject tarjetaJSON, ArrayList<ArrayList<String>> listaTarjetas) {
        String nombrePais = (String) tarjetaJSON.get("Pais");
        String nombreTarjeta = (String) tarjetaJSON.get("Simbolo");
        ArrayList<String> arrayTarjeta = new ArrayList<String>();
        arrayTarjeta.add(nombrePais);
        arrayTarjeta.add(nombreTarjeta);
        listaTarjetas.add(arrayTarjeta);
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

    private ArrayList<ArrayList<String>> obtenerDiccionarioTarjetas(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        ArrayList<ArrayList<String>> listaTarjetas = new ArrayList<ArrayList<String>>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            Object obj = parser.parse(reader);

            JSONArray tarjetasJSON = (JSONArray) obj;

            tarjetasJSON.forEach(pais -> parsearTarjeta((JSONObject) pais, listaTarjetas));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listaTarjetas;
    }



}