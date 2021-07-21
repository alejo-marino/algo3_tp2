package edu.fiuba.algo3.modelo;

public class Tarjeta {

    private final Pais pais;
    private final String simbolo;
    private boolean fueActivada;

    private Integer cantidadEjercitosActivacion;

    public Tarjeta(Pais pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
        this.fueActivada = false;
        this.cantidadEjercitosActivacion = 2;
    }

    public void activar(Jugador jugador) {
        if (pais.esDuenio(jugador) && !fueActivada) {
            pais.reforzar(cantidadEjercitosActivacion);
            fueActivada = true;
        }
    }

    public void reiniciarEstado() {
        fueActivada = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tarjeta)) {
            return false;
        }
        Tarjeta otraTarjeta = (Tarjeta) obj;
        return this.simbolo.equals(otraTarjeta.getSimbolo());
    }

    @Override
    public String toString() {
        return pais.toString();
    }

    public String getSimbolo() {
        return this.simbolo;
    }
}
