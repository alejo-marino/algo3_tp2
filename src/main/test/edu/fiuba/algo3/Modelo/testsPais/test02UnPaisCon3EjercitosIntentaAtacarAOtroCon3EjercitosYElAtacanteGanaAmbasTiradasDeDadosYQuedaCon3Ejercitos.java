package edu.fiuba.algo3.Modelo.testsPais;

public class test02UnPaisCon3EjercitosIntentaAtacarAOtroCon3EjercitosYElAtacanteGanaAmbasTiradasDeDadosYQuedaCon3Ejercitos {
    boolean hayError = false;
    Jugador rojo = Jugador('rojo');
    Jugador azul = Jugador('azul');

    Pais atacante = Pais(rojo);
    Pais defensor = Pais(azul);
    agregarEjercito(atacante, 3);
    agregarEjercito(defensor, 3);

    atacarATest(atacante, 2, defensor, 1);

    assertEquals(cantEjercitos(atacante), 3);
}

