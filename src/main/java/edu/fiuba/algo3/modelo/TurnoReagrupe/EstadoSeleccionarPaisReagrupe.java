package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.Pais;

public interface EstadoSeleccionarPaisReagrupe {

    void seleccionarPais(Pais pais);

    void cancelarAccion();

    void reagrupar(int cantidadEjercitos);

    boolean puedoCancelar();

    boolean puedoReagrupar();

    int getEjercitosParaReagrupar();

    boolean paisPuedeSeleccionarse(Pais pais);

    boolean paisSeleccionado(String nombrePais);
}
