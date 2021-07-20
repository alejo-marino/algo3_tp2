package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;


public class RondaDeAtaqueYReagrupe implements TipoDeRonda {

    private final Tablero tablero;
    private Pais paisAtacante;
    private Pais paisDefensor;

    public RondaDeAtaqueYReagrupe(Tablero tablero) {
        this.tablero = tablero;
    }

    public void terminarAtaque(Tablero tablero) {
        //return RondaDeReagrupe(tablero);
    }

    public void atacar(int cantidadEjercitos) {
        this.estadoTurno.atacar(cantidadEjercitos);
    }

    public void reagrupar(int cantidadEjercitos) {
        this.estadoTurno.reagrupar(cantidadEjercitos);
    }

    public void reforzar(Integer ejercitosAReforzar) {
        this.estadoTurno.reforzar(ejercitosAReforzar);
    }

    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return this.estadoTurno.seleccionarPais(nombrePais, jugador);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }
}
