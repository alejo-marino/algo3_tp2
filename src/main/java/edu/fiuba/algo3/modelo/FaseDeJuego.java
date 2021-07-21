package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeJuego implements Fase {

    Ronda rondaDeJuego;   // empieza en ataque, al hacer siguienteRonda pasa a ser de refuerzo y asi sucesivamente.
    Integer numeroDeRonda;

    public FaseDeJuego (Tablero tablero) {
        rondaDeJuego = new RondaDeAtaqueYReagrupe(tablero);
        this.numeroDeRonda = 1;
    }

    @Override
    public void empezarTurno(Jugador jugador) {
        rondaDeJuego.empezarTurno(jugador);
    }


    @Override
    public Fase siguienteRonda() {
        rondaDeJuego = rondaDeJuego.siguienteRonda();
        return this;
    }

    @Override
    public String getFaseActual() {
        return "Fase de juego";
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return rondaDeJuego.seleccionarPais(nombrePais, jugador);
    }
    @Override
    public void atacar(int cantidadEjercitos) {   // las variables atacante y defensor son innecesarias
        rondaDeJuego.atacar(cantidadEjercitos);
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        rondaDeJuego.reagrupar(cantidadEjercitos);
    }

    @Override
    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        rondaDeJuego.canjearTarjetas(tarjetasACanjear);
    }

    @Override
    public void reforzar(int cantidadEjercitosAAgregar) {
        rondaDeJuego.reforzar(cantidadEjercitosAAgregar);
    }

}
