package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class DadosDeSeisCaras {
    public ArrayList<Integer> tirarDados(int cantidadDeTiradas) {
        ArrayList<Integer> tiradas = new ArrayList<>();
        Random ran = new Random();
        double aux;
        int tirada;
        for (int i = 0; i < cantidadDeTiradas; i++) {
            tiradas.add(ran.nextInt(6) + 1);
        }
        Collections.sort(tiradas);
        Collections.reverse(tiradas);
        return tiradas;
    }
}

