/*
  Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang
  ITS der Hochschule
  für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3H.darstellung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import praktikum.aufgabe3H.ISimObjekt;
import praktikum.aufgabe3H.Pirat;
import praktikum.aufgabe3H.Schiff;

import java.util.Arrays;
import java.util.List;

/**
 * Eine einfache Darstellung für die Simulation einer Fähre mit Autos.
 */
public class Piratensimulation extends Application {

  @Override
  public void start(Stage primaryStage) {
    StackPane wurzel = new StackPane();
    Scene szene = new Scene(wurzel, 600, 300);
    Darstellungscanvas darstellungscanvas = new Darstellungscanvas(600, 300, objekteAnlegen());
    wurzel.getChildren().add(darstellungscanvas);
    primaryStage.setTitle("Piratensimulation");
    primaryStage.setScene(szene);
    primaryStage.show();
  }

  /**
   * Hier werden die Simulationsobjekte angelegt.
   */
  public List<ISimObjekt> objekteAnlegen() {
    Schiff schiff = new Schiff(3);
    List<ISimObjekt> iSimObjekts = Arrays.asList(
        schiff,
        new Pirat(schiff, "Peter"),
        new Pirat(schiff, "Hans"),
        new Pirat(schiff, "Otto"),
        new Pirat(schiff, "Max"),
        new Pirat(schiff, "Karl"),
        new Pirat(schiff, "Bernd"),
        new Pirat(schiff, "Fritz")
    );
    for (ISimObjekt iSimObjekt : iSimObjekts) {
      new Thread(iSimObjekt).start();
    }

    return iSimObjekts;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
