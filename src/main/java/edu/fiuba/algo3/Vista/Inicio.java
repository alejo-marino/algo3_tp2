package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Inicio {
    public static void display(ArrayList<TextField> nombreJugadores) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Nombre Jugadores");

        ArrayList nombreDeJugadores = new ArrayList();
        for (TextField nombre : nombreJugadores) {
            nombreDeJugadores.add(nombre.getText());
        }

        System.out.println(nombreDeJugadores);



    }
}
