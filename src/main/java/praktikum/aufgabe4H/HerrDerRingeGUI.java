/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4H;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import praktikum.aufgabe2H.Figur;
import praktikum.aufgabe2H.Film;
import praktikum.aufgabe2H.HerrDerRingeDaten;
import praktikum.aufgabe2H.Zitat;

/**
 * Eine GUI für den Herr-Der-Ringe-Datensatz
 */
public class HerrDerRingeGUI extends Application {

  @Override
  public void start(Stage primaryStage) {
    HerrDerRingeDaten herrDerRingeDaten = new HerrDerRingeDaten();

    primaryStage.setTitle("Herr der Ringe");

    TextField textField = new TextField();

    TableView<Figur> tableViewFigur = new TableView<>();
    TableView<Film> tableViewFilm = new TableView<>();
    TableView<Zitat> tableViewZitat = new TableView<>();

    ObservableList<Figur> figurObservableList = FXCollections.observableArrayList(
      herrDerRingeDaten.getFiguren());
    ObservableList<Film> filmObservableList = FXCollections.observableArrayList(
      herrDerRingeDaten.getFilme());
    ObservableList<Zitat> zitatObservableList = FXCollections.observableArrayList(
      herrDerRingeDaten.getZitate());


    HBox hBox = new HBox(tableViewFigur, tableViewFilm);
    VBox vBox = new VBox(textField, hBox, tableViewZitat);


    Scene szene = new Scene(vBox, 600, 400, Color.WHITE);
    primaryStage.setScene(szene);
    primaryStage.show();
  }

  /**
   * Programmstart
   */
  public static void main(String[] args) {
    Application.launch();
  }
}
