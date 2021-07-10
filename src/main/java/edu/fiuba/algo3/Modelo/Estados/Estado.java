package edu.fiuba.algo3.Modelo.Estados;

import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;

public abstract class Estado  {
    public Tablero tablero;
    public Turno turno;

    public abstract void iniciarFase();

    public abstract void atacar();

    public abstract Estado siguienteEstado();
}
