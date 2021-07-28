package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;

public class EstadoTarjetaDesactivada implements EstadoTarjeta {

    private final Tarjeta tarjeta;
    private final Pais pais;

    public EstadoTarjetaDesactivada(Tarjeta tarjeta, Pais pais) {
        this.tarjeta = tarjeta;
        this.pais = pais;
    }

    @Override
    public void hacerActivable() {}

    @Override
    public void activar(Jugador jugador) {
        int cantidadEjercitosActivacion = 2;
        if (pais.esDuenio(jugador)) {
            pais.reforzar(cantidadEjercitosActivacion);
            tarjeta.cambiarEstado(new EstadoTarjetaActivada(tarjeta, pais));
        } else {
            throw new ActivacionTarjetaInvalidaException("El país de esta tarjeta no te pertenece.");
        }
    }
}
