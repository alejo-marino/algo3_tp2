package edu.fiuba.algo3.modelo.estadosDeTurno;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisNoLimitrofeException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisPropioException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueConPaisAjenoException;

public class EstadoTurnoAtacar {
    /*
    private Tablero tablero;

    public EstadoTurnoAtaque(Tablero tablero) {
        this.tablero = tablero;
    }

    public Pais seleccionarPais(Jugador jugador, String nombrePais) {
        Pais pais = tablero.seleccionarPais(jugador,pais);
        if (!pais.esDuenio(jugador)) {
            throw new AtaqueConPaisAjenoException("No");
        }
        return pais;
    }

    public Pais seleccionarPaisLimitrofe(Pais atacante, String nombrePaisDefensor) {
        return tablero.seleccionarPais(Jugador jugador, nombrePaisDefensor);
        Pais defensor = tablero.seleccionarPais(nombrePaisDefensor);
        if (!atacante.esLimitrofeCon(defensor)) {
            throw new AtaqueAPaisNoLimitrofeException("No");
        }
        if (atacante.esAliado(defensor)) {
            throw new AtaqueAPaisPropioException("No");
        }
        return defensor;
    }



    public boolean atacar( Pais atacante, Pais defensor, int cantEjercitos) {

    }
}

/*

if(clickeaste en un pais) {
    String pais = self.getPais(posx, posy)
    juego.seleccionarPais(pais);

} else if (clickeaste en siguiente) {
    juego.siguiente()
} else if (clickeaste ok en el menu para mover ejercitos) {
    */
}
