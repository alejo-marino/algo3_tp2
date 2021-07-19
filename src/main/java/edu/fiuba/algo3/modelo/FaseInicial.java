package edu.fiuba.algo3.modelo;

import java.util.Queue;

public class FaseInicial implements Fase {

    RondaInicial rondaInicial;


    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero referenciaTablero) {   // {5, 3}
        this.rondaInicial = new RondaInicial(colaDeNumerosDeRefuerzoPorRonda, referenciaTablero);
    }

    public Fase siguienteRonda() {
        if (this.rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
            return this;
        }

        return new FaseDeJuego(rondaInicial.pedirTablero());
    }



    @Override
    public String getFaseActual(){
        return "Fase inicial";
    }

    public void siguienteTurno() {
        this.rondaInicial.siguienteTurno();
    }


    public String getRondaActual() {
        return rondaInicial.getRondaActual();
    }

    public void reforzar(Pais pais, int cantidadEjercitos) {
        this.rondaInicial.reforzar(pais, cantidadEjercitos);
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return rondaInicial.seleccionarPais(nombrePais, jugador);
    }

    @Override
    public void atacar(Pais atacante, Pais defensor, int cantidadEjercitos) {
        rondaInicial.atacar(cantidadEjercitos);
    }

    @Override
    public void reagrupar(Pais origen, Pais destino, int cantidadEjercitos) {
        rondaInicial.reagrupar(origen, destino, cantidadEjercitos);
    }
}
