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
        this.paisesLimitrofes = new ArrayList<Pais>();
    }

    public int getEjercitos() {
        return batallon.getEjercitos();
    }

    public int getEjercitosParaAtacar() {
        return batallon.getEjercitosParaAtacar();
    }

/*    public ArrayList<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }*/

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

/*    public void conquistarFinal(Pais conquistado){
        conquistado.duenio = this.duenio;
        int cantEjercitosAMover = input.nextInt();
        int cantEjercitos = this.batallon.getEjercitos();
        if (cantEjercitosAMover < 1 || cantEjercitosAMover > (cantEjercitos - 1)) {
            System.out.println("La cantidad a movilizar es invalida.");
            this.conquistar(conquistado);
            return;
        }
        this.disminuirEjercitos(cantEjercitosAMover);
        conquistado.reforzar(cantEjercitosAMover);
    }*/

    public void conquistar(Pais conquistado){
        conquistado.duenio = this.duenio;
        conquistado.reforzar(1);
        this.disminuirEjercitos(1);
    }

    public void hacerLimitrofe(Pais pais) {
        this.paisesLimitrofes.add(pais);
    }
/*
    public void esLimitrofeCon(Pais pais) {
        if (!this.paisesLimitrofes.contains(pais)) {
            throw new AtaqueAPaisNoLimitrofeException(this + " y " + pais.toString() + " no son limitrofes.");
        }
    }

    public void verificarAtaque(Jugador jugador, Pais defensor) {
        this.esDuenioPais(jugador);
        this.esLimitrofeCon(defensor);
        this.esDuenioPaisAtacado(defensor);

    }*/
/*
    private void esDuenioPaisAtacado(Pais defensor) {
        if (this.esAliado(defensor)) {
            throw new AtaqueAPaisPropioException(defensor + " te pertenece, no podes atacarlo.");
        }
    }

    private void esDuenioPais(Jugador jugador) {
        if (jugador != duenio) {
            throw new AtaqueConPaisAjenoException("Este país no te pertenece");
        }
    }
*/
    public void serConquistadoPor(Pais atacante) {
        if (!this.tengoEjercitos()) {
            atacante.conquistar(this);
        }
    }
}