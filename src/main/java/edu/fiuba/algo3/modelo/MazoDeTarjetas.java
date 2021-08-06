package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CanjeInvalidoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MazoDeTarjetas {

    Queue<Tarjeta> tarjetasSinUsar;
    ArrayList<Tarjeta> tarjetasEnUso;

    public MazoDeTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        Collections.shuffle(listaTarjetas);
        this.tarjetasSinUsar = convertirListaDeTarjetasACola(listaTarjetas);
        this.tarjetasEnUso = new ArrayList<>();
    }

    private Queue<Tarjeta> convertirListaDeTarjetasACola(ArrayList<Tarjeta> tarjetas) {
        return new LinkedList<>(tarjetas);
    }

    public void darTarjeta(Jugador jugador) {
        Tarjeta tarjeta = tarjetasSinUsar.remove();
        tarjeta.darA(jugador);
        tarjetasEnUso.add(tarjeta);
    }

    // TODO: metodo para pruebas
    public void darTarjetaPredeterminado(Jugador jugador, String nombreTarjeta) {
        Tarjeta tarjeta = null;
        for (Tarjeta tarjetaSinUsar: tarjetasSinUsar) {
            if (tarjetaSinUsar.toString().equals(nombreTarjeta)) {
                tarjeta = tarjetaSinUsar;
            }
        }
        tarjeta.darA(jugador);
        tarjetasEnUso.add(tarjeta);
        tarjetasSinUsar.remove(tarjeta);
    }

    public Integer canjearTarjetas(ArrayList<String> nombreTarjetasACanjear, Jugador jugador) {
        ArrayList<Tarjeta> tarjetasACanjear = seleccionarTarjetas(nombreTarjetasACanjear);
        Integer numeroDeEjercitosAGanar = 0;

        if (!tarjetasPertenecenAJugador(tarjetasACanjear, jugador)) {
            throw new CanjeInvalidoException("Las tarjetas no te pertenecen.");
        }
        boolean comodin = false;
        for (Tarjeta tarjeta : tarjetasACanjear) {
            if (tarjeta.getSimbolo().equals("Comodin")) {
                comodin = true;
                break;
            }
        }
        if (!comodin) {
            if (tarjetasACanjear.get(0).tieneIgualSimbolo(tarjetasACanjear.get(1))) {
                for (Tarjeta tarjeta : tarjetasACanjear) {
                    if (!tarjeta.tieneIgualSimbolo(tarjetasACanjear.get(0))) {
                        throw new CanjeInvalidoException("Las tarjetas deben ser de igual simbolo o todas distintas.");
                    }
                }
            } else {
                ArrayList<Tarjeta> tarjetasACanjearCopia = new ArrayList<>(tarjetasACanjear);

                Tarjeta tarjeta;
                while (!tarjetasACanjearCopia.isEmpty()) {
                    tarjeta = tarjetasACanjearCopia.remove(0);
                    for (Tarjeta otraTarjeta : tarjetasACanjearCopia) {
                        if (tarjeta.tieneIgualSimbolo(otraTarjeta)) {
                            throw new CanjeInvalidoException("Las tarjetas deben ser de igual simbolo o todas distintas.");
                        }
                    }
                }
            }
        }
        this.devolverAlMazo(tarjetasACanjear);
        numeroDeEjercitosAGanar += jugador.canjeValido();
        return numeroDeEjercitosAGanar;

    }

    private void devolverAlMazo(ArrayList<Tarjeta> tarjetasACanjear) {
        for (Tarjeta tarjeta: tarjetasACanjear) {
            tarjeta.devolverAlMazo();
            tarjetasEnUso.remove(tarjeta);
            tarjetasSinUsar.add(tarjeta);
        }
    }

    private boolean tarjetasPertenecenAJugador(ArrayList<Tarjeta> tarjetasACanjear, Jugador jugador) {
        for (Tarjeta tarjeta: tarjetasACanjear) {
            if (!tarjeta.esDuenio(jugador)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Tarjeta> seleccionarTarjetas(ArrayList<String> tarjetasACanjear) {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        for (String nombreTarjeta: tarjetasACanjear) {
            tarjetas.add(seleccionarTarjeta(nombreTarjeta));
        }
        return tarjetas;
    }

    public ArrayList<String> obtenerNombreTarjetasDe(Jugador jugador) {
        ArrayList<String> nombreTarjetas = new ArrayList<>();
        for (Tarjeta tarjeta: tarjetasEnUso) {
            if (tarjeta.esDuenio(jugador)) {
                nombreTarjetas.add(tarjeta.toString());
            }
        }
        return nombreTarjetas;
    }

    public void activarTarjeta(String nombreTarjeta) {
        Tarjeta tarjeta = seleccionarTarjeta(nombreTarjeta);
        tarjeta.activar();
    }

    private Tarjeta seleccionarTarjeta(String nombreTarjeta) {
        for (Tarjeta tarjeta: tarjetasEnUso) {
            if (tarjeta.toString().equals(nombreTarjeta)) {
                return tarjeta;
            }
        }
        throw new CanjeInvalidoException("");
    }

}
