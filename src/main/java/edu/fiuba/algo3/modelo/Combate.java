package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Combate {
    private final Pais atacante;
    private final Pais defensor;

    public Combate(Pais paisAtacante, Pais paisDefensor){
        this.atacante = paisAtacante;
        this.defensor = paisDefensor;
    }

    public void combatir() {

        int cantEjercitosAtacante = this.atacante.getEjercitosParaAtacar();
        int cantEjercitosDefensor = this.defensor.getEjercitos();

        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        ArrayList<Integer> tiradaAtacante = dados.tirarDados(cantEjercitosAtacante);
        ArrayList<Integer> tiradaDefensor = dados.tirarDados(cantEjercitosDefensor);

        determinarGanador(tiradaAtacante, tiradaDefensor);
    }

    public void combatePredeterminado( ArrayList<Integer> tiradaAtacante, ArrayList<Integer> tiradaDefensor) {
        determinarGanador(tiradaAtacante, tiradaDefensor);
    }

    private void determinarGanador(ArrayList<Integer> tiradaAtacante, ArrayList<Integer> tiradaDefensor) {
        int encuentros = Math.min((tiradaAtacante.size()), (tiradaDefensor.size()));
        int ganaAtacante = 0;
        int ganaDefensor = 0;
        for (int i = 0; i < encuentros; i++) {
            if ( ganadorTirada( tiradaDefensor.get(i), tiradaAtacante.get(i))){
                ganaAtacante++;
            }
            else{
                ganaDefensor++;
            }
        }
        this.atacante.disminuirEjercitos(ganaDefensor);
        this.defensor.disminuirEjercitos(ganaAtacante);
        defensor.serConquistadoPor(atacante);
    }

    private boolean ganadorTirada(int tiradaDefensor, int tiradaAtacante) {
        return tiradaDefensor < tiradaAtacante;
    }
}
