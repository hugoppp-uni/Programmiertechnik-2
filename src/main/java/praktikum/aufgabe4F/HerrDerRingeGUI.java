/*
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 *  2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4F;

import javafx.application.Application;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        HBox kind3 = new HBox();
        kind3.setAlignment(Pos.BASELINE_CENTER);

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

        var listFilm = HerrDerRingeDaten.createListFilm();
        TableView<Film> tabelleFilm = new TableView<>();
        tabelleFilm.setMinWidth(400);
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

        var listZitat = HerrDerRingeDaten.createListZitat();
        TableView<Zitat> tabelleDialog = new TableView<>();
        tabelleDialog.setMinWidth(800);
        tabelleDialog.setItems(listZitat);
        TableColumn<Zitat, String> dialogSpalte = new TableColumn<>("Dialog");
        tabelleDialog.getColumns().add(dialogSpalte);
        dialogSpalte.setCellValueFactory(new PropertyValueFactory<>("dialog"));
        kind3.getChildren().add(tabelleDialog);

        tabelleFigur.getSelectionModel().selectedItemProperty()
          .addListener(((observable, oldValue, newValue) -> {
              try {
                  tabelleDialog.setItems(HerrDerRingeDaten
                    .zitatZuFigur(newValue.getName()));
              } catch (NullPointerException e) {
                  dialogSpalte.getColumns().clear();
              }
          }));

        tabelleFilm.getSelectionModel().selectedItemProperty()
          .addListener((observable, oldValue, newValue) -> {
              try {
                  var figur =
                    tabelleFigur.getSelectionModel().getSelectedItem();
                  var zitatList = HerrDerRingeDaten.zitatZuFilmFigur(figur,
                    Objects.requireNonNull(HerrDerRingeDaten.zitatZuFilm(newValue.getTitel())));
                  tabelleDialog.setItems(zitatList);
              } catch (Exception e) {
                  dialogSpalte.getColumns().clear();
              }
          });

        kommando.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ObservableList<Figur> figuren;
                    Pattern pattern = Pattern.compile("FILTER\\s(\\w{3,4})" +
                      "\\s=\\s(\\w+)");
                    Matcher matcher = pattern.matcher(kommando.getText());
                    if (matcher.find()) {
                        if (matcher.group(1).equals("NAME")) {
                            figuren = FXCollections
                              .observableArrayList(HerrDerRingeDaten
                                .findFigurName(matcher.group(2), listFiguren));
                            tabelleFigur.setItems(figuren);
                        } else if (matcher.group(1).equals("TYP")){
                            figuren = FXCollections
                              .observableArrayList(HerrDerRingeDaten
                                .findFigurTyp(matcher.group(2), listFiguren));
                            tabelleFigur.setItems(figuren);
                        }
                    }
                } catch (Exception e) {
                    tabelleFigur.getColumns().clear();
                }
            } else if (kommando.getText().isEmpty()) {
                tabelleFigur.getSelectionModel().clearSelection();
                tabelleFilm.getSelectionModel().clearSelection();
                tabelleFigur.setItems(listFiguren);
                tabelleDialog.setItems(listZitat);
            }
        });

        wurzel.getChildren().add(kind1);
        wurzel.getChildren().add(kind2);
        wurzel.getChildren().add(kind3);

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
