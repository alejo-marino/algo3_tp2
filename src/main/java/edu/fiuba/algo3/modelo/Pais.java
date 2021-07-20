package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {

    private Jugador duenio;
    private final Batallon batallon;
    private final ArrayList<Pais> paisesLimitrofes;
    private final String nombre;

    public Pais(String nombre, Jugador duenio) {
        this.nombre = nombre;
        this.duenio = duenio;
        this.batallon = new Batallon();
        this.paisesLimitrofes = new ArrayList<>();
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
    }

    public void disminuirEjercitos(int cantidadEjercitos) {
        batallon.disminuirEjercitos(cantidadEjercitos);
    }

    public boolean tengoEjercitos() {
        return batallon.tengoEjercitos();
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean esAliado(Pais pais) {
        return this.duenio == pais.getDuenio();
    }


    public void conquistar(Pais conquistado) {
        conquistado.duenio = this.duenio;
        conquistado.reforzar(1);
        this.disminuirEjercitos(1);
    }

    public void hacerLimitrofe(Pais pais) {
        this.paisesLimitrofes.add(pais);
    }

    public void serConquistadoPor(Pais atacante) {
        if (!this.tengoEjercitos()) {
            atacante.conquistar(this);
        }
    }

    public boolean esDuenio(Jugador jugador) {
        return (jugador ==duenio);
    }

    public int getEjercitosParaDefender() {
        return this.batallon.getEjercitosParaDefender();
    }
}