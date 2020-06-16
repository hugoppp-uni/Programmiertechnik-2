/*
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 *  2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4F;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import praktikum.aufgabe2FkeineAbgabe.Figur;
import praktikum.aufgabe2FkeineAbgabe.Film;
import praktikum.aufgabe2FkeineAbgabe.HerrDerRingeDaten;
import praktikum.aufgabe2FkeineAbgabe.Zitat;

/**
 * Eine GUI für den Herr-Der-Ringe-Datensatz
 */
public class HerrDerRingeGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Herr der Ringe");
        VBox wurzel = new VBox();

        HBox kind1 = new HBox();
        kind1.setAlignment(Pos.BASELINE_CENTER);
        HBox kind2 = new HBox();
        kind2.setAlignment(Pos.BASELINE_CENTER);

        Label kommandoLabel = new Label("Kommando: ");
        TextField kommando = new TextField();
        kommando.setMinWidth(730);
        kind1.getChildren().add(kommandoLabel);
        kind1.getChildren().add(kommando);

        TableView<Figur> tabelleFigur = new TableView<>();
        tabelleFigur.setMinSize(400, 10);
        tabelleFigur.setItems(HerrDerRingeDaten.createListFiguren());
        TableColumn<Figur, String> nameSpalte = new TableColumn<>("Name");
        tabelleFigur.getColumns().add(nameSpalte);
        nameSpalte.setCellValueFactory(name -> new SimpleStringProperty(
          name.getValue().getName().get()));
        TableColumn<Figur, String> typSpalte = new TableColumn<>("Typ");
        tabelleFigur.getColumns().add(typSpalte);
        typSpalte.setCellValueFactory(typ -> new SimpleStringProperty(
          typ.getValue().getTyp() == null ? "k. A." :
            typ.getValue().getTyp().get().toString()));
        TableColumn<Figur, String> geschlechtSpalte = new TableColumn<>(
          "Geschlecht");
        tabelleFigur.getColumns().add(geschlechtSpalte);
        geschlechtSpalte.setCellValueFactory(geschlecht -> new SimpleStringProperty(
          geschlecht.getValue().getGeschlecht() == null ? "k. A." :
            geschlecht.getValue().getGeschlecht().get() == null ? "k. A." :
              geschlecht.getValue().getGeschlecht().get().toString()));
        kind2.getChildren().add(tabelleFigur);

        TableView<Film> tabelleFilm = new TableView<>();
        tabelleFilm.setMinSize(400, 0);
        tabelleFilm.setItems(HerrDerRingeDaten.createListFilm());
        TableColumn<Film, String> titelSpalte = new TableColumn<>("Titel");
        tabelleFilm.getColumns().add(titelSpalte);
        titelSpalte.setCellValueFactory(titel ->
          new SimpleStringProperty(titel.getValue().getTitel()));
        TableColumn<Film, String> laufzeitSpalte = new TableColumn<>(
          "Laufzeit in Minuten");
        tabelleFilm.getColumns().add(laufzeitSpalte);
        laufzeitSpalte.setCellValueFactory(laufzeit ->
          new SimpleStringProperty(String.valueOf(laufzeit.getValue()
            .getLaufzeit())));
        kind2.getChildren().add(tabelleFilm);

        TableView<Zitat> tabelleDialog = new TableView<>();
        tabelleDialog.setMinWidth(800);
        tabelleDialog.setItems(HerrDerRingeDaten.createListZitat());
        TableColumn<Zitat, String> dialogSpalte = new TableColumn<>("Dialog");
        tabelleDialog.getColumns().add(dialogSpalte);
        dialogSpalte.setCellValueFactory(zitat ->
          new SimpleStringProperty(zitat.getValue().getDialog()));

        wurzel.getChildren().add(kind1);
        wurzel.getChildren().add(kind2);
        wurzel.getChildren().add(tabelleDialog);
        Scene szene = new Scene(wurzel, 800, 400, Color.WHITE);
        primaryStage.setScene(szene);
        primaryStage.show();
    }

    /**
     * Programmstart
     */
    public static void main(String[] args) {
        launch(args);
    }
}
