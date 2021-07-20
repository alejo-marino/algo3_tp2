package edu.fiuba.algo3.modelo;

public class FaseDeJuego implements Fase {

    TipoDeRonda rondaDeJuego;   // empieza en ataque, al hacer siguienteRonda pasa a ser de refuerzo y asi sucesivamente.
    Integer numeroDeRonda;

    public FaseDeJuego (Tablero tablero) {
        rondaDeJuego = new RondaDeAtaqueYReagrupe(tablero);
        this.numeroDeRonda = 1;
    }

    @Override
    public void siguienteTurno() {

    }

    @Override
    public void reforzar(Pais argentina, int cantidadEjercitos) {

    }

    @Override
    public Fase siguienteRonda() {
        return this;
    }

    @Override
    public String getFaseActual() {
        return "Fase de juego";
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return null;
    }

    public void atacar(Pais atacante, Pais defensor, int cantidadEjercitos) {}

    public void reagrupar(Pais origen, Pais destino, int cantidadEjercitos) {}

    public void reforzar() {}
}
