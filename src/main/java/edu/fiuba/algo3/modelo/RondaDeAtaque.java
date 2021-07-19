package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;


public class RondaDeAtaque implements TipoDeRonda {

    private final Tablero tablero;
    private Pais paisAtacante;
    private Pais paisDefensor;

    public RondaDeAtaque(Tablero tablero) {
        this.tablero = tablero;
    }

    public void terminarAtaque(Tablero tablero) {
        //return RondaDeReagrupe(tablero);
    }

    public void atacar(int cantidadEjercitos) {
        this.paisPuedeAtacar(cantidadEjercitos);
        Combate combate = new Combate(paisAtacante, paisDefensor, cantidadEjercitos);
        combate.combatir();
    }

    private void paisPuedeAtacar(int cantidadEjercitos) {
        if ((this.paisAtacante == null) || (this.paisDefensor == null)) {
            throw new AtaqueInvalidoException("Pais defensor o atacante faltante");
        }
        if (cantidadEjercitos > 3 ||  (cantidadEjercitos < 1) || ((cantidadEjercitos > paisAtacante.getEjercitosParaAtacar()))) {
            throw new EjercitosInvalidosException("No hay suficientes ejércitos para atacar");
        }
    }
    public void reagrupar(Pais origen, Pais destino, int cantidadEjercitos) {
        throw new ReagrupeInvalidoException("No es posible reagrupar mientras estas atacando");
    }

    public void reforzar(Pais paisAReforzar, Integer ejercitosAReforzar) {

    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) { return null;
    }
}
