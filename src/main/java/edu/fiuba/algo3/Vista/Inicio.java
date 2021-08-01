package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.TableroController;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Inicio {

    public static ArrayList jugadores;
    public static ArrayList<Button> botonesPaises = new ArrayList();
    public static Pane content;

    public static void display(ArrayList<TextField> nombreJugadores) throws IOException {
        Stage stage = new Stage();


        ArrayList<String> nombreDeJugadores = new ArrayList<>();
        for (TextField nombre : nombreJugadores) {
            nombreDeJugadores.add(nombre.getText());
        }
        jugadores = nombreDeJugadores;
        System.out.println(nombreDeJugadores);
        Juego juego = Juego.getInstancia();
        juego.setearJugadores(nombreDeJugadores);

        FXMLLoader loader = new FXMLLoader();

        URL fxmlLocation = Inicio.class.getClassLoader().getResource("vistas/Tablero.fxml");
        loader.setLocation(fxmlLocation);

        content = loader.load();
        for (Node nodo : content.getChildren()) {
            if (nodo.getClass() == Button.class) {
                botonesPaises.add((Button) nodo);
            }
        }


        Scene scene = new Scene(content);
        stage.setScene(scene);
        stage.setTitle("ALGOTEG");
        stage.setFullScreen(true);
        
        stage.show();

    }
}
