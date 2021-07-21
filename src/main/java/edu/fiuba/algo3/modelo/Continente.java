package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {

    private final String nombre;
    private final ArrayList<Pais> paises;
    private final Integer bonus;

    public Continente(String nombre, Integer bonus) {
        this.nombre = nombre;
        this.paises = new ArrayList<>();
        this.bonus = bonus;
    }

    public void agregarPais(Pais pais) {
        this.paises.add(pais);
    }

    public Integer obtenerBonusDeContinentePara(Jugador jugador) {
        if (paises.size() == 0) {
            return 0;
        }
        for (Pais pais: paises) {
            if (!pais.esDuenio(jugador)) {
                return 0;
            }
        }
        return bonus;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public int paisesConquistadosPor(Jugador jugador) {
        int nroDePaisesConquistados = 0;
        for (Pais pais: paises) {
            if (pais.esDuenio(jugador)) {
                nroDePaisesConquistados++;
            }
        }
        return nroDePaisesConquistados;
    }
}
