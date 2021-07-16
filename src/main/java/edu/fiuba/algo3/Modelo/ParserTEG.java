package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.ArchivoNoEncontradoException;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.Dictionary;
import java.util.Hashtable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ParserTEG {
    /*
    public void parsearTablero(String rutaArchivo) {
        //File archivoFronteras = new File(rutaArchivo);
        this.obtenerDiccionariosPaisesYContinentes(String rutaArchivo);
        this.obtenerDiccionarioCartas(rutaArchivo);
    }

    public void parsearPais(JSONObject paisJSON, Hashtable<String, String[]> diccPaises, Hashtable<String, ArrayList> diccContinentes) {

        nombrePais = ;
        nombreContinente = ;
        String[] stringLimitrofes = (paisJSON.get("Li Con")).split(","));

        diccPaises.put(nombrePais, stringLimitrofes);
        if (!(diccContinentes.containsKey(nombreContinente))) {
            ArrayList<String> listaPaisesEnContinente = new ArrayList<String>;
            diccContinentes.put(nombreContinente, listaPaisesEnContinente);
        }
        // diccContinentes.get(nombreContinente) devolvera el array de paises en el continente por lo que debo agregar el pais al mismo
        (diccContinentes.get(nombreContinente)).add(nombrePais);
    }

    public void parsearPais(JSONObject cartasJSON, ArrayList<ArrayList> diccCartas) {


    }

    public void obtenerDiccionariosPaisesYContinentes(String rutaArchivo) {

        JSONParser parser = new JSONParser();
        Hashtable<String, String[]> diccPaises = new Hashtable<String, String[]>();
        Hashtable<String, ArrayList> diccContinentes = new Hashtable<String, ArrayList>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            Object obj = parser.parse(reader);

            JSONArray paisesJSON = (JSONArray) obj;

            paisesJSON.forEach(pais -> parsearPais((JSONObject) pais);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void obtenerDiccionarioCartas(String rutaArchivo) {
        JSONParser parser = new JSONParser();
        ArrayList<ArrayList> diccCartas = new ArrayList<ArrayList>();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            Object obj = parser.parse(reader);

            JSONArray cartasJSON = (JSONArray) obj;

            cartasJSON.forEach(pais -> parsearCarta((JSONObject) pais);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
     */


}
