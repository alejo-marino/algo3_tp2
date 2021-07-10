package edu.fiuba.algo3.Modelo.Estados;

import edu.fiuba.algo3.Modelo.Estados.Estado;
import edu.fiuba.algo3.Modelo.Exceptions.NoSePuedeAtacarEnEstaEtapaException;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;

public class EstadoInicial extends Estado {


    public EstadoInicial(Turno turno, Tablero tablero) {
        this.tablero = tablero;
        this.turno = turno;
    }

    @Override
    public void iniciarFase() {
        turno.iniciarTurnos();
        turno.repartirCartas();
    }

    @Override
    public void atacar() {
        throw new NoSePuedeAtacarEnEstaEtapaException("No se puede atacar en etapa inicial.");
    }

    @Override
    public Estado siguienteEstado() {
        return new EstadoPonerFichas();
    }
}
