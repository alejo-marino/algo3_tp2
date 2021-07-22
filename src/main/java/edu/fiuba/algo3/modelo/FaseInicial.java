package edu.fiuba.algo3.modelo;

import java.util.Queue;

public class FaseInicial extends Fase {


    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero tablero) {
        super(new RondaInicial(colaDeNumerosDeRefuerzoPorRonda, tablero));   // {5, 3}
    }

    public Fase siguienteRonda() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        if (rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
            return this;
        }

        return new FaseDeJuego(rondaInicial.pedirTablero());
    }

    @Override
    public String getFaseActual(){
        return "Fase inicial";
    }

    public String getRondaActual() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        return rondaInicial.getRondaActual();
    }

}
