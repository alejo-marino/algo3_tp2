package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class TurnoAtaque implements EstadoTurno {

    private Pais paisAtacante;
    private Pais paisDefensor;
    private Jugador jugador;

    public TurnoAtaque(Jugador jugador) {
        this.jugador = jugador;
    }

    public void atacar(int cantidadEjercitos) {
        this.paisPuedeAtacar(cantidadEjercitos);
        Combate combate = new Combate(paisAtacante, paisDefensor, cantidadEjercitos);
        combate.combatir();
        if (!this.paisAtacante.puedeAtacar()) {
            this.cancelarAccion();
        }
    }


    private void paisPuedeAtacar(int cantidadEjercitos) {
        if ((this.paisAtacante == null) || (this.paisDefensor == null)) {
            throw new AtaqueInvalidoException("Pais defensor o atacante faltante");
        }
        if (cantidadEjercitos > 3 || (cantidadEjercitos < 1) || ((cantidadEjercitos > paisAtacante.getEjercitosParaAtacar()))) {
            throw new EjercitosInvalidosException("No hay suficientes ejércitos para atacar");
        }
    }

    @Override
    public Pais seleccionarPais(Pais paisSeleccionado) {
        if (this.jugador == null) {
            throw new TurnoSinEmpezarException();
        }

        if (this.paisAtacante != null && this.paisDefensor != null) {
            throw new PaisesYaSeleccionadosException("Los paises atacantes y defensores ya estan seleccionados, apreta 'Atacar' o 'Cancelar accion'.");
        }

        if (this.paisAtacante == null) {
            if (!paisSeleccionado.esDuenio(jugador)) {
                throw new SeleccionaPaisAjenoException("El pais: " + paisSeleccionado + " no te pertenece");
            }
            if (!paisSeleccionado.puedeAtacar()) {
                throw new EjercitosInvalidosException("El pais: " + paisSeleccionado + " no tiene ejercitos suficientes para atacar");
            }
            paisAtacante = paisSeleccionado;
            return paisAtacante;
        }
        if (paisSeleccionado.esAliado(paisAtacante)) {
            throw new AtaqueAPaisPropioException("No podes atacar a un pais propio");
        }
        this.paisDefensor = paisSeleccionado;
        return paisSeleccionado;
    }

    public void cancelarAccion() {
        paisAtacante = null;
        paisDefensor = null;
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new ReagrupeInvalidoException("No es posible reagrupar mientras estas atacando");
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        throw new RefuerzoInvalidoException("No es posible reforzar en un turno de ataque");
    }

    @Override
    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        throw new CanjeNoPermitidoException("No se puede canjear en una ronda de ataque y reagrupe");
    }

    @Override
    public void activarTarjeta(Tarjeta tarjetaAActivar) {
        throw new ActivacionTarjetaInvalidaException("No podés activar la tarjeta en un turno de ataque.");
    }
}
