package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tirada {
    private ArrayList tiradaAtacante, tiradaDefensor;
    private DadosDeSeisCaras dado;
    private Combate combate;

    public Tirada(Combate combate) {
       dado = new DadosDeSeisCaras();
       this.combate = combate;
    }

    public void tirar(int cantEjercitosAtacante, int cantEjercitosDefensor) {
        tiradaAtacante = dado.tirarDados(cantEjercitosAtacante);
        tiradaDefensor = dado.tirarDados(cantEjercitosDefensor);
        determinarGanador(tiradaAtacante, tiradaDefensor);
    }

    public void tirarPredeterminado(ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        determinarGanador(tiradaAtacante, tiradaDefensor);
    }
    private void determinarGanador(ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        int encuentros = Math.min((tiradaAtacante.size()), (tiradaDefensor.size()));
        int ganaAtacante = 0;
        int ganaDefensor = 0;
        for (int i = 0; i < encuentros; i++) {
            if (ganadorTirada((int) tiradaDefensor.get(i), (int) tiradaAtacante.get(i))) {
                ganaAtacante++;
            } else {
                ganaDefensor++;
            }
        }
        combate.modificarEjercitosAtacante(ganaDefensor);
        combate.modificarEjercitosDefensor(ganaAtacante);
    }
    private boolean ganadorTirada(int tiradaDefensor, int tiradaAtacante) {
        return tiradaDefensor < tiradaAtacante;
    }
}
