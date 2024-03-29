/*
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 *  2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4FkeineAbgabe;

import javafx.application.Application;
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
import javafx.scene.paint.Paint;
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
        HerrDerRingeDaten h = new HerrDerRingeDaten();
        VBox wurzel = new VBox();

        HBox kind1 = new HBox();
        kind1.setAlignment(Pos.BASELINE_LEFT);
        HBox kind2 = new HBox();
        kind2.setAlignment(Pos.BASELINE_CENTER);

        Label filterEingabe = new Label("Filtereingabe nach folgendem " +
          "Muster: 'FILTER NAME/TYP = Suchwert'");
        filterEingabe.setTextFill(Paint.valueOf("#02C226"));
        Label kommandoLabel = new Label("Kommando: ");
        TextField kommando = new TextField();
        kommando.setMinWidth(930);
        kind1.getChildren().add(kommandoLabel);
        kind1.getChildren().add(kommando);

        var listFiguren = h.createListFiguren();
        TableView<Figur> tabelleFigur = new TableView<>();
        tabelleFigur.setMinWidth(500);
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

        var listFilm = h.createListFilm();
        TableView<Film> tabelleFilm = new TableView<>();
        tabelleFilm.setMinWidth(500);
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

        var listZitat = h.createListZitat();
        TableView<Zitat> tabelleDialog = new TableView<>();
        tabelleDialog.setMinWidth(800);
        tabelleDialog.setItems(listZitat);
        TableColumn<Zitat, String> dialogSpalte = new TableColumn<>("Dialog");
        tabelleDialog.getColumns().add(dialogSpalte);
        dialogSpalte.setCellValueFactory(new PropertyValueFactory<>("dialog"));

        tabelleFigur.getSelectionModel().selectedItemProperty()
          .addListener(((observable, oldValue, newValue) -> {
              try {
                  tabelleDialog.setItems(h
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
                  var zitatList = h.zitatZuFilmFigur(figur,
                    Objects.requireNonNull(h.zitatZuFilm(newValue.getTitel())));
                  tabelleDialog.setItems(zitatList);
              } catch (Exception e) {
                  dialogSpalte.getColumns().clear();
              }
          });

        kommando.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ObservableList<Figur> figuren;
                    Pattern pattern = Pattern.compile("(\\w{3,4})" +
                      "\\s=\\s(\\w+)");
                    Matcher matcher = pattern.matcher(kommando.getText());
                    if (matcher.find()) {
                        if (matcher.group(1).toLowerCase().equals("name")) {
                            figuren = FXCollections
                              .observableArrayList(h
                                .findFigurName(matcher.group(2), listFiguren));
                            tabelleFigur.setItems(figuren);
                        } else if (matcher.group(1).toLowerCase().equals("typ"
                        )) {
                            figuren = FXCollections
                              .observableArrayList(h
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

        wurzel.getChildren().add(filterEingabe);
        wurzel.getChildren().add(kind1);
        wurzel.getChildren().add(kind2);
        wurzel.getChildren().add(tabelleDialog);

        Scene szene = new Scene(wurzel, 1000, 600, Color.WHITE);
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
