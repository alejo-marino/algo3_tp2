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
        rondaDeJuego.siguienteTurno();
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
    public void reforzar(int cantidadEjercitosAAgregar) {
        rondaDeJuego.reforzar(cantidadEjercitosAAgregar);
    }

}
