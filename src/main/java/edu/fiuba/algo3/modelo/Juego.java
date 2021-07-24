package edu.fiuba.algo3.modelo;



public class Juego {

    private static Juego instancia = new Juego();

    private Juego() {
        this.colores = new LinkedList<>();
        this.colores.add("077bb");  // azul
        this.colores.add("cc3311");  // rojo
        this.colores.add("ee7733");  // amarillo
        this.colores.add("009988");  // verde
        this.colores.add("ee3377");  // rosa
        this.colores.add("000000");  // negro
    }

    public static Juego getInstancia() {
        return instancia;
    }

}
