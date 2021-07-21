package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CanjeConTarjetaAjenaException;

import java.util.ArrayList;

public class Jugador {

    private final Integer NRO_EJERCITOS_PRIMER_CANJE = 4;
    private final Integer NRO_EJERCITOS_SEGUNDO_CANJE = 7;
    private final Integer NRO_EJERCITOS_TERCER_CANJE = 10;

    private final String nombreJugador;
    private final Batallon batallon;
    private ArrayList<Tarjeta> tarjetas;
    private Integer numeroDeCanje;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.batallon = new Batallon();
        this.tarjetas = new ArrayList<>();
        this.numeroDeCanje = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador)) {
            return false;
        }
        Jugador otroJugador = (Jugador) o;
        return this.nombreJugador.equals(otroJugador.getNombre());
    }

    protected String getNombre() {
        return this.nombreJugador;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public Integer canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        for (Tarjeta tarjeta: tarjetasACanjear) {
            if (!tarjetas.contains(tarjeta)) {
                throw new CanjeConTarjetaAjenaException("La tarjeta " + tarjeta + " no te pertenece");
            }
        }
        if (tarjetasACanjear.get(0).equals(tarjetasACanjear.get(1))) {
            for (Tarjeta tarjeta: tarjetasACanjear) {
                if (!tarjeta.equals(tarjetasACanjear.get(0))) {
                    return 0;
                }
            }
        } else {
            ArrayList<Tarjeta> tarjetasACanjearCopia = new ArrayList<>(tarjetasACanjear);

            Tarjeta tarjeta;
            while (!tarjetasACanjearCopia.isEmpty()) {
                tarjeta = tarjetasACanjearCopia.remove(0);
                for (Tarjeta otraTarjeta: tarjetasACanjearCopia) {
                    if (tarjeta.equals(otraTarjeta)) {
                        return 0;
                    }
                }
            }
        }

        for (Tarjeta tarjeta: tarjetasACanjear) {
            tarjetas.remove(tarjeta);
        }

        this.numeroDeCanje++;
        return calcularEjercitosCanje();
    }

    private Integer calcularEjercitosCanje() {
        switch (numeroDeCanje) {
            case 1:
                return NRO_EJERCITOS_PRIMER_CANJE;
            case 2:
                return NRO_EJERCITOS_SEGUNDO_CANJE;
            case 3:
                return NRO_EJERCITOS_TERCER_CANJE;
            default:
                return (numeroDeCanje - 1) * 5;
        }
    }

}

