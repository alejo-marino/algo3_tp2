package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

public class BotonPais implements Observer {

    private final Button botonPais;
    private final SistemaDeTurnos sistema;

    public BotonPais(Button botonPais, SistemaDeTurnos sistema) {
        this.botonPais = botonPais;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        String color = sistema.getColorDePais(botonPais.getText());
        String colorTexto = Constantes.colorNegro;
        if (color.equals(colorTexto)) {
            colorTexto = Constantes.colorBlanco;
        }

        if (sistema.paisPuedeSeleccionarse(botonPais.getText())) {
            botonPais.setDisable(false);
        } else {
            botonPais.setDisable(true);
            colorTexto = Constantes.colorBlanco;
        }
        botonPais.setStyle("-fx-background-color:" + color +"; -fx-text-fill:" + colorTexto);
    }

}
