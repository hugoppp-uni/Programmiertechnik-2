/*
  Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
  2 im Studiengang
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

import static praktikum.aufgabe3H.ISimObjekt.Ort;

/**
 * Eine einfache Darstellung für die Simulation einer Fähre mit Autos.
 */
public class Piratensimulation extends Application {

  @Override
  public void start(Stage primaryStage) {
    StackPane wurzel = new StackPane();
    Scene szene = new Scene(wurzel, 600, 300);
    Darstellungscanvas darstellungscanvas = new Darstellungscanvas(
      600,
      300,
      objekteAnlegen()
    );
    wurzel.getChildren().add(darstellungscanvas);
    primaryStage.setTitle("Piratensimulation");
    primaryStage.setScene(szene);
    primaryStage.show();
  }

  /**
   * Hier werden die Simulationsobjekte angelegt.
   */
  public List<ISimObjekt> objekteAnlegen() {
    Schiff schiff = new Schiff(3, 5, 5);
    Pirat.setRumlaufDauerMin(8);
    Pirat.setRumlaufDauerMax(55);
    List<ISimObjekt> iSimObjekts = Arrays.asList(schiff,
      new Pirat(schiff, "Peter", Ort.WESTLAND),
      new Pirat(schiff, "Hans", Ort.WESTLAND),
      new Pirat(schiff, "Otto", Ort.WESTLAND),
      new Pirat(schiff, "Max", Ort.WESTLAND),
      new Pirat(schiff, "Karl", Ort.OSTLAND),
      new Pirat(schiff, "Bernd", Ort.OSTLAND),
      new Pirat(schiff, "Fritz", Ort.OSTLAND),
      new Pirat(schiff, "Heinz", Ort.OSTLAND)
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
