/*
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 *  2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4F;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
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

        var listFiguren = HerrDerRingeDaten.createListFiguren();
        TableView<Figur> tabelleFigur = new TableView<>();
        tabelleFigur.setMinWidth(400);
        tabelleFigur.setItems(listFiguren);
        TableColumn<Figur, String> nameSpalte = new TableColumn<>("Name");
        nameSpalte.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabelleFigur.getColumns().add(nameSpalte);
        TableColumn<Figur, String> typSpalte = new TableColumn<>("Typ");
        tabelleFigur.getColumns().add(typSpalte);
        typSpalte.setCellValueFactory(new PropertyValueFactory<>("typ"));
        TableColumn<Figur, String> geschlechtSpalte = new TableColumn<>(
          "Geschlecht");
        tabelleFigur.getColumns().add(geschlechtSpalte);
        geschlechtSpalte.setCellValueFactory(new PropertyValueFactory<>(
          "geschlecht"));
        kind2.getChildren().add(tabelleFigur);

        TableView<Film> tabelleFilm = new TableView<>();
        tabelleFilm.setMinWidth(400);
        var listFilm = HerrDerRingeDaten.createListFilm();
        tabelleFilm.setItems(listFilm);
        TableColumn<Film, String> titelSpalte = new TableColumn<>("Titel");
        tabelleFilm.getColumns().add(titelSpalte);
        titelSpalte.setCellValueFactory(new PropertyValueFactory<>("titel"));
        TableColumn<Film, String> laufzeitSpalte = new TableColumn<>(
          "Laufzeit in Minuten");
        tabelleFilm.getColumns().add(laufzeitSpalte);
        laufzeitSpalte.setCellValueFactory(new PropertyValueFactory<>(
          "laufzeit"));
        kind2.getChildren().add(tabelleFilm);

        TableView<Zitat> tabelleDialog = new TableView<>();
        tabelleDialog.setMaxWidth(800);
        var listZitat = HerrDerRingeDaten.createListZitat();
        tabelleDialog.setItems(listZitat);
        TableColumn<Zitat, String> dialogSpalte = new TableColumn<>("Dialog");
        tabelleDialog.getColumns().add(dialogSpalte);
        dialogSpalte.setCellValueFactory(new PropertyValueFactory<>("dialog"));

        tabelleFigur.getSelectionModel().selectedItemProperty()
          .addListener(((observable, oldValue, newValue) -> {
              try {
                  listZitat.setAll(HerrDerRingeDaten
                    .zitatZuFigur(newValue.getName()));
              } catch (NullPointerException e) {
                  listZitat.clear();
              }
          }));

        tabelleFilm.getSelectionModel().selectedItemProperty()
          .addListener((observable, oldValue, newValue) -> {
              try {
                  listZitat.setAll(HerrDerRingeDaten
                    .zitatZuFilm(newValue.getTitel()));
              } catch (Exception e) {
                  listZitat.clear();
              }
          });

        kommando.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    listFiguren.setAll(HerrDerRingeDaten
                      .findFigur(kommando.getText(), listFiguren));
                } catch (Exception e) {
                    listFiguren.clear();
                }
            }
        });

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
