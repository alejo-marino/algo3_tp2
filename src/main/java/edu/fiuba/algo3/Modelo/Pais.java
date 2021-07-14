package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ReforzarPaisAjenoError;

import java.util.ArrayList;

public class Pais {

    private Jugador duenio;
    private Batallon batallon;
    private ArrayList<Pais> paisesLimitrofes;
    private String nombre;

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

    public ArrayList<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }

    public Jugador getPaisOcupadoPor() {
        return duenio;
    }


    public void reforzar(Jugador jugador, int cantidadEjercitos) {
        if (jugador != duenio) {
            throw new ReforzarPaisAjenoError("Este pais no te pertenece");
        }
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
        return this.duenio == pais.getPaisOcupadoPor();
    }

    public void conquistar(Pais defensor){
        defensor.duenio = this.duenio;
        defensor.reforzar(this.duenio, 1);
        this.disminuirEjercitos(1);
    }
    public void hacerLimitrofe(Pais pais) {
        this.paisesLimitrofes.add(pais);
    }

    public boolean esLimitrofeCon(Pais pais) {
        return this.paisesLimitrofes.contains(pais);
    }
}
