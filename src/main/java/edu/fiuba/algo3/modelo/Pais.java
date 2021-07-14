package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisNoLimitrofeException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisPropioException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueConPaisAjenoException;
import edu.fiuba.algo3.modelo.excepciones.ReforzarPaisAjenoError;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void conquistarFinal(Pais conquistado){
        conquistado.duenio = this.duenio;
        Scanner input = new Scanner(System.in);
        System.out.println("Cuantas piezas queres pasar a " + conquistado.toString() + "?");
        int cantEjercitosAMover = input.nextInt();
        int cantEjercitos = this.batallon.getEjercitos();
        if (cantEjercitosAMover < 1 || cantEjercitosAMover > (cantEjercitos - 1)) {
            System.out.println("La cantidad a movilizar es invalida.");
            this.conquistar(conquistado);
            return;
        }
        this.disminuirEjercitos(cantEjercitosAMover);
        conquistado.reforzar(this.duenio, cantEjercitosAMover);
    }

    public void conquistar(Pais conquistado){
        conquistado.duenio = this.duenio;
        conquistado.reforzar(this.duenio, 1);
        this.disminuirEjercitos(1);
    }

    public void hacerLimitrofe(Pais pais) {
        this.paisesLimitrofes.add(pais);
    }

    public boolean esLimitrofeCon(Pais pais) {
        return this.paisesLimitrofes.contains(pais);
    }

    public void verificar(Jugador jugador, Pais defensor) {
        if (jugador != duenio) {
            throw new AtaqueConPaisAjenoException("Este país no te pertenece");
        }
        if (!this.esLimitrofeCon(defensor)) {
            throw new AtaqueAPaisNoLimitrofeException(this.toString() + " y " + defensor.toString() + " no son limitrofes.");
        }
        if (this.esAliado(defensor)) {
            throw new AtaqueAPaisPropioException(defensor.toString()+ " te pertenece, no podes atacarlo.");
        }

    }
}
