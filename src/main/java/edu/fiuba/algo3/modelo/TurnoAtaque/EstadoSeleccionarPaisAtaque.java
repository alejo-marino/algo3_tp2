package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Pais;

public interface EstadoSeleccionarPaisAtaque {

    void seleccionarPais(Pais pais);

    void atacar(int cantidadEjercitos);

    void cancelarAccion();

    int getEjercitosParaAtacar();

    boolean puedoAtacar();

    boolean puedoCancelar();

    boolean paisPuedeSeleccionarse(Pais pais);

    boolean puedoReagrupar();

    void reagrupar(int cantidadEjercitos);

}
