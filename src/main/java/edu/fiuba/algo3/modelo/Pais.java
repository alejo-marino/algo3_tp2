package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisSinDuenioAsignadoException;

import java.util.ArrayList;
import java.util.Observable;

public class Pais extends Observable {

    private Jugador duenio;
    private final Batallon batallon;
    private final ArrayList<Pais> paisesLimitrofes;
    private final String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.duenio = null;
        this.batallon = new Batallon();
        this.paisesLimitrofes = new ArrayList<>();
    }

    public void asignarDuenio(Jugador jugador) {
        this.duenio = jugador;
        setChanged();
        notifyObservers();
    }

    public int getEjercitos() {
        return batallon.getEjercitos();
    }

    public int getEjercitosParaAtacar() {
        return batallon.getEjercitosParaAtacar();
    }

    public boolean puedeAtacar() {
        return this.getEjercitosParaAtacar() > 0;
    }


    public Jugador getDuenio() {
        return duenio;
    }

    public void reforzar(int cantidadEjercitos) {
        this.batallon.agregarEjercitos(cantidadEjercitos);
        setChanged();
        notifyObservers();
    }

    public void disminuirEjercitos(int cantidadEjercitos) {
        batallon.disminuirEjercitos(cantidadEjercitos);
        setChanged();
        notifyObservers();
    }

    public boolean tengoEjercitos() {
        return batallon.tengoEjercitos();
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean esAliado(Pais pais) {
        if (duenio != null) {
        return this.duenio == pais.getDuenio();
        } else {
            throw new PaisSinDuenioAsignadoException(nombre + " no tiene duenio.");
        }
    }


    public void conquistar(Pais conquistado) {
        if (duenio != null) {
            conquistado.setDuenio(this.duenio);
            conquistado.reforzar(1);
            this.disminuirEjercitos(1);
        } else {
            throw new PaisSinDuenioAsignadoException(nombre + " no tiene duenio.");
        }
    }

    private void setDuenio(Jugador duenio) {
        this.duenio = duenio;
        setChanged();
        notifyObservers();
    }

    public void hacerLimitrofe(Pais pais) {
        this.paisesLimitrofes.add(pais);
    }

    public boolean esDuenio(Jugador jugador) {
        return (jugador == duenio);
    }

    public int getEjercitosParaDefender() {
        return this.batallon.getEjercitosParaDefender();
    }

    public boolean esLimitrofe(Pais otroPais) {
        return paisesLimitrofes.contains(otroPais);
    }

    public String getColor() {
        return duenio.getColor();
    }

    public void actualizar() {
        setChanged();
        notifyObservers();
    }
}