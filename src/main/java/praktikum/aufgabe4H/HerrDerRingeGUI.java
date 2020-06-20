/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4H;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import praktikum.aufgabe2H.Figur;
import praktikum.aufgabe2H.Film;
import praktikum.aufgabe2H.HerrDerRingeDaten;
import praktikum.aufgabe2H.Zitat;
import java.util.stream.Collectors;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * Eine GUI für den Herr-Der-Ringe-Datensatz
 */
public class HerrDerRingeGUI extends Application {

  /**
   * Programmstart
   */
  public static void main(String[] args) {
    Application.launch();
  }

  @SuppressWarnings({"unchecked", "SpellCheckingInspection"})
  @Override
  public void start(Stage primaryStage) {
    HerrDerRingeDaten herrDerRingeDaten = new HerrDerRingeDaten();

    var figurList = herrDerRingeDaten.getFiguren();
    var figurObservableList = observableArrayList(figurList);
    TableView<Figur> tableViewFigur = new TableView<>(figurObservableList);
    var vornameTableColumnColumn = new TableColumn<Figur, String>("Name");
    vornameTableColumnColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    var typTableColumn = new TableColumn<Figur, String>("Typ");
    typTableColumn.setCellValueFactory(new PropertyValueFactory<>("typ"));
    var geschlechtTableColumn = new TableColumn<Figur, String>("Geschlecht");
    geschlechtTableColumn.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
    tableViewFigur.getColumns()
                  .setAll(vornameTableColumnColumn, typTableColumn, geschlechtTableColumn);

    TableView<Film> tableViewFilm =
      new TableView<>(observableArrayList(herrDerRingeDaten.getFilme()));
    var titelTableColumn = new TableColumn<Film, String>("Titel");
    titelTableColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
    var laufzeitTableColumn = new TableColumn<Film, String>("Laufzeit");
    laufzeitTableColumn.setCellValueFactory(new PropertyValueFactory<>("laufzeit"));
    tableViewFilm.getColumns().setAll(titelTableColumn, laufzeitTableColumn);

    var zitatObservableList = observableArrayList(herrDerRingeDaten.getZitate());
    TableView<Zitat> tableViewZitat = new TableView<>(zitatObservableList);
    var zitateTableColumn = new TableColumn<Zitat, String>("Zitate");
    zitateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dialog"));
    tableViewZitat.getColumns().setAll(zitateTableColumn);
    //filter when changing figur
    tableViewFigur.getSelectionModel()
                  .selectedItemProperty()
                  .addListener((observable, oldValue, newFigur) -> zitatObservableList.setAll(
                    herrDerRingeDaten.getZitateOfId(newFigur.getId()).stream()
                            .filter( figur -> figur.getFilmId().equals(tableViewFilm.getSelectionModel().getSelectedItem().getId()))
                            .collect(Collectors.toList())));
    //filter when changing film
    tableViewFilm.getSelectionModel()
                 .selectedItemProperty()
                 .addListener((observable, oldValue, newFilm) -> zitatObservableList.setAll(
                    herrDerRingeDaten.getZitateOfId(tableViewFigur.getSelectionModel().getSelectedItem().getId()).stream()
                            .filter( zitat -> zitat.getFilmId().equals(tableViewFilm.getSelectionModel().getSelectedItem().getId()))
                            .collect(Collectors.toList())));

    SplitPane horizontalSplitPaneFigurFilm = new SplitPane(tableViewFigur, tableViewFilm);
    SplitPane verticalSplitPaneFigurfilmZitat =
      new SplitPane(horizontalSplitPaneFigurFilm, tableViewZitat);
    verticalSplitPaneFigurfilmZitat.setOrientation(Orientation.VERTICAL);

    TextField textField = new TextField();
    textField.textProperty()
             .addListener((observable, oldValue, newValue) -> figurObservableList.setAll(
               herrDerRingeDaten.filterFiguren(figurList, newValue)));

    VBox wurzel = new VBox(textField, verticalSplitPaneFigurfilmZitat);
    primaryStage.setTitle("Herr der Ringe");
    Scene szene = new Scene(wurzel, 1000, 600, Color.WHITE);
    primaryStage.setScene(szene);
    primaryStage.show();
  }



}
