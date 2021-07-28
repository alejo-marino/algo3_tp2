package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.TarjetaEnMazoException;

public class Tarjeta {

    private final String simbolo;
    private final Pais pais;

    private EstadoTarjeta estadoTarjeta;
    private Jugador duenio;

    public Tarjeta(Pais pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
        this.estadoTarjeta = new EstadoTarjetaDesactivada(this, pais);
        this.duenio = null;
    }

    public void cambiarEstado(EstadoTarjeta estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public void activar() {
        if (duenio == null) {
            throw new TarjetaEnMazoException("");
        }
        estadoTarjeta.activar(duenio);
    }

    public void devolverAlMazo() {
        estadoTarjeta.hacerActivable();
        this.duenio = null;
    }

    public boolean tieneIgualSimbolo(Tarjeta otraTarjeta) {
        return this.simbolo.equals(otraTarjeta.getSimbolo());
    }

    @Override
    public String toString() {
        return pais.toString() + "/" + simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void darA(Jugador jugador) {
        this.duenio = jugador;
    }

    public boolean esDuenio(Jugador jugador) {
        return duenio == jugador;
    }
}
