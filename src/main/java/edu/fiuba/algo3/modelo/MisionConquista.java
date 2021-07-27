package edu.fiuba.algo3.modelo;


import java.util.Map;

public class MisionConquista implements Mision{

    private final Map<String, Integer> paisesAConquistar;
    private Jugador jugador;
    private final Juego juego;

    public MisionConquista(Juego juego, Map<String, Integer> paisesAConquistar) {
        this.jugador = null;
        this.juego = juego;
        this.paisesAConquistar = paisesAConquistar;
    }

    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
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
