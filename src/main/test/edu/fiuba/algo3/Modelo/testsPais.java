package edu.fiuba.algo3.Modelo;

public class testsPais {

    public test01UnPaisIntentaAtacarAOtroPeroSoloTieneUnEjercito {
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

    public test02UnPaisCon3EjercitosIntentaAtacarAOtroCon3EjercitosYElAtacanteGanaAmbasTiradasDeDadosYQuedaCon3Ejercitos {
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

    public test03UnPaisCon3EjercitosIntentaAtacarAOtroCon3EjercitosYElAtacanteGanaAmbasTiradasDeDadosYElDefennsorQuedaCon1Ejercito {
        boolean hayError = false;
        Jugador rojo = Jugador('rojo');
        Jugador azul = Jugador('azul');

        Pais atacante = Pais(rojo);
        Pais defensor = Pais(azul);
        agregarEjercito(atacante, 3);
        agregarEjercito(defensor, 3);

        atacarATest(atacante, 2, defensor, 1);

        assertEquals(cantEjercitos(defensor), 1);
    }

    public test04UnPaisCon3EjercitosIntentaAtacarAOtroCon3EjercitosYElDefensorPerteneceAAzul {
        boolean hayError = false;
        Jugador rojo = Jugador('rojo');
        Jugador azul = Jugador('azul');

        Pais atacante = Pais(rojo);
        Pais defensor = Pais(azul);
        agregarEjercito(atacante, 3);
        agregarEjercito(defensor, 3);

        atacarATest(atacante, 2, defensor, 1);

        assertTrue(pertenceAJugador(defensor, azul));
    }
}
