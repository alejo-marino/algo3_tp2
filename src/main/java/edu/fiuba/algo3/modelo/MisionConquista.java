package edu.fiuba.algo3.modelo;


import java.util.Map;

public class MisionConquista implements Mision{

    private Map<String, Integer> paisesAConquistar;
    private Jugador jugador;
    private Juego juego;

    public MisionConquista(Jugador jugador, Juego juego, Map<String, Integer> paisesAConquistar) {
        this.jugador = jugador;
        this.juego = juego;
        this.paisesAConquistar = paisesAConquistar;
    }

    public String verMision() {
        StringBuilder resultado = new StringBuilder("Misión de Conquista: Ocupar ");

        for (Map.Entry<String, Integer> tupla : paisesAConquistar.entrySet()) {
            String nombreContinente = tupla.getKey();
            Integer numeroPaises = tupla.getValue();
            resultado.append(numeroPaises).append(" países de ");
            resultado.append(nombreContinente).append(". ");
        }

        return resultado.toString();
    }

    public boolean completoMision(){

        for (Map.Entry<String, Integer> tupla : paisesAConquistar.entrySet()) {
            String nombreContinente = tupla.getKey();
            Integer numeroPaises = tupla.getValue();
            if (juego.paisesConquistadosPorEn(jugador, nombreContinente) < numeroPaises) {
                return false;
            }
        }
        return true;
    }

    public boolean sigueSiendoPosible() {
        return true;
    }

}
