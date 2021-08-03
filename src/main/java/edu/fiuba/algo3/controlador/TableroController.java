package edu.fiuba.algo3.controlador;

import com.sun.glass.ui.Clipboard;
import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import edu.fiuba.algo3.modelo.excepciones.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import javax.swing.*;
import java.net.URL;
import java.util.*;

import static java.lang.Integer.parseInt;

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
    public Label labelAlaska;
    public Label labelMejico;
    public Label labelCalifornia;
    public Label labelOregon;
    public Label labelNuevaYork;
    public Label labelYukon;
    public Button botonReforzar;
    public ChoiceBox choiceBoxReforzar;
    public Button botonAtacar;
    public ChoiceBox choiceBoxAtacar;
    public Button botonTerminarAtaque;
    public Button botonReagrupar;
    public ChoiceBox choiceBoxReagrupar;
    public Button botonSiguienteTurno;
    public Button botonCancelarAccion;
    public Button botonMisiones;
    private SistemaDeTurnos sistema;
    private ArrayList<Label> labelJugadores;


    public void initialize(URL location, ResourceBundle resources) {
        this.nombreJugadores = Inicio.jugadores;
        coloresJugadores.add("#0077bb");
        coloresJugadores.add("#cc3311");
        coloresJugadores.add("#ee7733");
        coloresJugadores.add("#009988");
        coloresJugadores.add("#ee3377");
        coloresJugadores.add("#000000");
        int contador = 0;
        this.labelJugadores = new ArrayList<>();
        for (String nombreJugador: this.nombreJugadores) {
            Label label = new Label(nombreJugador);
            this.labelJugadores.add(label);
            label.setTextFill(Color.web(this.coloresJugadores.get(contador)));
            colorPorJugador.put(nombreJugador, this.coloresJugadores.get(contador));
            infoJugadores.getChildren().addAll(label);
            contador++;
        }

        Map<String, Label> diccionarioLabels = new HashMap<>();
        diccionarioLabels.put("Canada", labelCanada);
        diccionarioLabels.put("Alaska", labelAlaska);
        diccionarioLabels.put("Mejico", labelMejico);
        diccionarioLabels.put("California", labelCalifornia);
        diccionarioLabels.put("Oregon", labelOregon);
        diccionarioLabels.put("Nueva York", labelNuevaYork);
        diccionarioLabels.put("Yukon", labelYukon);

        Map<String, ArrayList<Observer>> diccionarioObserversPais = crearDiccionarioDeObserversPais(diccionarioLabels);

//        Juego juego = Juego.getInstancia();
        this.sistema = Juego.getInstancia().iniciarJuego(diccionarioObserversPais);
        ArrayList<Observer> turnosObservers = crearListaObserversTurnos();
        agregarObserversASistema(turnosObservers);
        this.sistema.empezarTurno();
    }

    private void agregarObserversASistema(ArrayList<Observer> turnosObservers) {
        for (Observer observer: turnosObservers) {
            sistema.addObserver(observer);
        }
    }

    private Map<String, ArrayList<Observer>> crearDiccionarioDeObserversPais(Map<String, Label> diccionarioLabels) {
       Map<String, ArrayList<Observer>> diccionarioObserver = new HashMap<>();

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.put(nombre, new ArrayList<>()));

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.get(nombre).add(new LabelPais(label, nombre)));

       return diccionarioObserver;
    }

    private ArrayList<Observer> crearListaObserversTurnos(){
        ArrayList<Observer> turnosObservers = new ArrayList<>();
        turnosObservers.add(new BotonAtacar(botonAtacar, choiceBoxAtacar, botonTerminarAtaque, sistema));
        turnosObservers.add(new BotonReforzar(botonReforzar, choiceBoxReforzar, sistema));
        turnosObservers.add(new BotonCancelarAccion(botonCancelarAccion, sistema));
        turnosObservers.add(new BotonSiguienteTurno(botonSiguienteTurno, sistema));
        turnosObservers.add(new LabelsJugadores(labelJugadores, sistema));
        turnosObservers.add(new BotonReagrupe(botonReagrupar, choiceBoxReagrupar, sistema));

        return turnosObservers;
    }

    public void handleBotonPais(ActionEvent actionEvent) {
        Button botonApretado = (Button) actionEvent.getSource();
        try {
            sistema.seleccionarPais(botonApretado.getText());
        } catch (SeleccionaPaisAjenoException | AtaqueAPaisNoLimitrofeException | AtaqueAPaisPropioException
                | ReagrupeAPaisAjenoException | ReagrupeAPaisNoLimitrofeException | EjercitosInvalidosException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    public void handleBotonReforzar(ActionEvent actionEvent) {
        sistema.reforzar((int) choiceBoxReforzar.getSelectionModel().getSelectedItem());
    }

    public void handleBotonSiguienteTurno(ActionEvent actionEvent) {
        try {
            sistema.empezarTurno();
        } catch(NoReforzoTodosLosEjercitosException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No reforzó todos los ejércitos.");
            alert.show();
        }
    }

    public void handleBotonAtacar(ActionEvent actionEvent) {
        try {
            sistema.atacar((Integer) choiceBoxAtacar.getSelectionModel().getSelectedItem());
        } catch (JugadorGanoException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (AtaqueInvalidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    public void handleBotonReagrupar(ActionEvent actionEvent) {
        try {
            sistema.reagrupar((Integer) choiceBoxReagrupar.getSelectionModel().getSelectedItem());
        } catch (PaisNoSeleccionadoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    public void handleBotonCancelarAccion(ActionEvent actionEvent) {
        sistema.cancelarAccion();
    }


    public void handleBotonTerminarAtaque(ActionEvent actionEvent) {
        sistema.terminarAtaque();
    }

    public void handleVerMisiones(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(sistema.verMisiones());
        alert.show();
    }
}
