package edu.fiuba.algo3.modelo;

import java.util.Queue;

public class FaseInicial extends Fase {

    private final SistemaDeTurnos sistema;
    private final Juego juego;

    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Juego juego, SistemaDeTurnos sistema) {
        super(new RondaInicial(colaDeNumerosDeRefuerzoPorRonda, juego));   // {5, 3}
        this.juego = juego;
        this.sistema = sistema;
    }

    public void siguienteRonda() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        if (rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
        } else {
            sistema.cambiarFase(new FaseDeJuego(juego));
        }
    }

    @Override
    public String getNombreDeFaseActual(){
        return "Fase inicial";
    }

    public String getRondaActual() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        return rondaInicial.getRondaActual();
    }

}
