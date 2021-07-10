package edu.fiuba.algo3.Modelo.Estados;

import edu.fiuba.algo3.Modelo.Exceptions.NoSePuedeAtacarEnEstaEtapaException;

public class EstadoPonerFichas extends Estado{
    @Override
    public void iniciarFase() {

    }

    @Override
    public void atacar() {
        throw new NoSePuedeAtacarEnEstaEtapaException("No se puede atacar en etapa colocacion fichas.");
    }

    @Override
    public Estado siguienteEstado() {
        return this;
    }
}
