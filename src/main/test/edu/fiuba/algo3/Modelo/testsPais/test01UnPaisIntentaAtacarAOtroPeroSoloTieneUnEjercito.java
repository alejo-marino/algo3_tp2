package edu.fiuba.algo3.Modelo.testsPais;

public class test01UnPaisIntentaAtacarAOtroPeroSoloTieneUnEjercito {
    boolean hayError = false;
    Jugador rojo = Jugador('rojo');
    Jugador azul = Jugador('azul');

    Pais atacante = Pais(rojo);
    Pais defensor = Pais(azul);
    agregarEjercito(atacante, 1);
    agregarEjercito(defensor, 1);

    try: {
        atacarA(atacante, defensor);
    } catch EjercitosInsuficientesError {          (assertThrows)
            hayError = true.
    };
    deny(hayError);
}

