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
        this.cantidadEjercitosActivacion = 3;
    }

    public Integer activar(Jugador jugador) {
        if (pais.esDuenio(jugador) && !fueActivada) {
            fueActivada = true;
            return cantidadEjercitosActivacion;
        }
        return 0;
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
        return this.simbolo.equals(otraTarjeta.simbolo);
    }
}
