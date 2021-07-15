package edu.fiuba.algo3.Vista;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;
import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{
    Stage window;
    Button button;

    Scene escenaCantidadJugadores, escenaInicial;

    @Override
    public void start(Stage stage) {
        window = stage;
    // Escena 1


        button = new Button("Empezar Juego");
        button.setOnAction(e -> window.setScene(escenaCantidadJugadores));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        escenaInicial = new Scene(layout, 300, 300);

    //Escena 2

        TextField input = new TextField("Cantidad Jugadores");
        Button button2 = new Button("Empezar");
        button2.setOnAction(e ->{
            try {
                Juego juegoNuevo = new Juego(Integer.parseInt(input.getText()));
                SeleccionNombreJugadores.display("Nombre jugadores", Integer.parseInt(input.getText()));

            }catch (CantidadErroneaDeJugadoresError error){
                AlertBox.display("Error", error.getMessage());
            }
        });

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(20,20,20,20));
        layout2.getChildren().addAll(input,button2);
        escenaCantidadJugadores = new Scene(layout2, 300, 300);

        // Config ventana inicial
        window.setOnCloseRequest(e -> {
            e.consume();
            cerrarPrograma();
        });
        window.setScene(escenaInicial);
        window.setTitle("ALGO-TEG");
        window.show();
    }

    public void cerrarPrograma() {
        Boolean respuesta = ConfirmBox.display("Desea Salir?");
        if (respuesta) {
            window.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}