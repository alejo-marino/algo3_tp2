package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;

public class EstadoTarjetaActivada implements EstadoTarjeta {

    private final Tarjeta tarjeta;
    private final Pais pais;

    public EstadoTarjetaActivada(Tarjeta tarjeta, Pais pais) {
        this.tarjeta = tarjeta;
        this.pais = pais;
    }

    @Override
    public void hacerActivable() {
        this.tarjeta.cambiarEstado(new EstadoTarjetaDesactivada(tarjeta, pais));
    }

    @Override
    public void activar(Jugador jugador) {
        throw new ActivacionTarjetaInvalidaException("Esta tarjeta ya fue activada.");
    }

}
