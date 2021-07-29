package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;

import static edu.fiuba.algo3.modelo.Constantes.numeroEjercitosActivacion;

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
        if (pais.esDuenio(jugador)) {
            pais.reforzar(numeroEjercitosActivacion);
            tarjeta.cambiarEstado(new EstadoTarjetaActivada(tarjeta, pais));
        } else {
            throw new ActivacionTarjetaInvalidaException("El país de esta tarjeta no te pertenece.");
        }
    }
}
