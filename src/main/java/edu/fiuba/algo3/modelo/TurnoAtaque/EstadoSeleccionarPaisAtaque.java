package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Pais;

public interface EstadoSeleccionarPaisAtaque {

    void seleccionarPais(Pais pais);

    void atacar(int cantidadEjercitos);

    void cancelarAccion();

    int getEjercitosParaAtacar();

    boolean puedoAtacar();

    boolean puedoCancelar();
}
