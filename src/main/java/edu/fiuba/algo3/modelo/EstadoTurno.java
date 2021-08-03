package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface EstadoTurno {

    void atacar(int cantidadEjercitosAtacantes);

    void seleccionarPais(Pais paisSeleccionado);

    void cancelarAccion();

    void reagrupar(int cantidadEjercitos);

    void reforzar(int cantidadEjercitosAReforzar);

    void canjearTarjetas(ArrayList<String> tarjetasACanjear, Juego juego);

    void activarTarjeta(String nombreTarjeta, Juego juego);

    boolean puedoAtacar();

    int getEjercitosParaAtacar();

    boolean puedoReforzar();

    int getEjercitosParaReforzar();

    boolean puedoCancelar();

    boolean estoyEnTurnoAtaque();

    boolean puedoPasarDeTurno();

    boolean puedoReagrupar();
}
