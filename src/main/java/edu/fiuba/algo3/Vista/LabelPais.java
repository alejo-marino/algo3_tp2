package edu.fiuba.algo3.Vista;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

public class LabelPais implements Observer {

    private final Label label;
    private final String nombrePais;

    public LabelPais(Label label, String nombrePais) {
        this.label = label;
        this.nombrePais = nombrePais;
    }

    @Override
    public void update(Observable o, Object arg) {
        int cantidadEjercitos = Juego.getInstancia().getEjercitosDe(nombrePais);
        String colorDuenio = Juego.getInstancia().getColorDe(nombrePais);
        label.setText(String.valueOf(cantidadEjercitos));
        System.out.println(String.valueOf(cantidadEjercitos));
        System.out.println(label.getText());
        label.setTextFill(Color.valueOf(colorDuenio));
    }

}
