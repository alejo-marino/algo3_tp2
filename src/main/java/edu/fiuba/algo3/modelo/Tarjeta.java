package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;

public class Tarjeta {

    private final String simbolo;
    private final Pais pais;

    private EstadoTarjeta estadoTarjeta;

    public Tarjeta(Pais pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
        this.estadoTarjeta = new EstadoTarjetaDesactivada(this, pais);
    }

    public void cambiarEstado(EstadoTarjeta estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public void activar(Jugador jugador) {
        estadoTarjeta.activar(jugador);
    }

    public void hacerActivable() {
        estadoTarjeta.hacerActivable();
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
