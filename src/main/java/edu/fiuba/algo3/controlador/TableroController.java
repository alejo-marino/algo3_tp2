package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.LabelPais;
import edu.fiuba.algo3.Vista.Inicio;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.*;

public class TableroController implements Initializable {

    public ArrayList<String> nombreJugadores;
    public Dictionary<String, String> colorPorJugador = new Hashtable<>();
    public Label labelCanada;
    private final ArrayList<String> coloresJugadores = new ArrayList<>();

    public VBox infoJugadores;
    public Button botonCanada;
    public Button botonOregon;
    public Button botonBrasil;
    public Button botonRusia;
    public Button botonArgentina;


    public void initialize(URL location, ResourceBundle resources) {
        this.nombreJugadores = Inicio.jugadores;
        coloresJugadores.add("#0077bb");
        coloresJugadores.add("#cc3311");
        coloresJugadores.add("#ee7733");
        coloresJugadores.add("#009988");
        coloresJugadores.add("#ee3377");
        coloresJugadores.add("#000000");
        int contador = 0;
        for (String nombreJugador: this.nombreJugadores) {
            Label label = new Label(nombreJugador);
            label.setTextFill(Color.web(this.coloresJugadores.get(contador)));
            colorPorJugador.put(nombreJugador, this.coloresJugadores.get(contador));
            infoJugadores.getChildren().addAll(label);
            contador++;
        }
        int contador2 = 0;
        for (Button boton: Inicio.botonesPaises) {
            boton.setText("hola");
            contador2++;
        }
        Map<String, Label> diccionarioLabels = new HashMap<>();
        diccionarioLabels.put("Canada", labelCanada);

        Map<String, ArrayList<Observer>> diccionarioObserversPais = crearDiccionarioDeObserversPais(diccionarioLabels);
        Juego juego = Juego.getInstancia();
        System.out.println(diccionarioObserversPais.get("Canada"));
        juego.iniciarJuego(diccionarioObserversPais);
    }

    private Map<String, ArrayList<Observer>> crearDiccionarioDeObserversPais(Map<String, Label> diccionarioLabels) {
       Map<String, ArrayList<Observer>> diccionarioObserver = new HashMap<>();

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.put(nombre, new ArrayList<>()));

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.get(nombre).add(new LabelPais(label, nombre)));

       return diccionarioObserver;
    }

    public void handleBotonPais(ActionEvent actionEvent) {
        Button botonApretado = (Button) actionEvent.getSource();
        try {
            Juego.getInstancia().seleccionarPais(botonApretado.getText());
        } catch (SeleccionaPaisAjenoException | AtaqueAPaisNoLimitrofeException | AtaqueAPaisPropioException
                | ReagrupeAPaisAjenoException | ReagrupeAPaisNoLimitrofeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        System.out.println(botonApretado.getText());
    }

    public void handleBotonRefuerzo(ActionEvent actionEvent) {
        Button bottonApretado = (Button) actionEvent.getSource();

    }

}
