package praktikum.aufgabe2FkeineAbgabe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Optional;
import java.util.stream.Stream;

import static praktikum.aufgabe2FkeineAbgabe.ReadingJSON.*;

public class HerrDerRingeDaten {
    private final ObservableList<Figur> figurenListe;
    private final ObservableList<Film> filmListe;
    private final ObservableList<Zitat> zitatListe;

    public HerrDerRingeDaten() {
        figurenListe = createListFiguren();
        filmListe = createListFilm();
        zitatListe = createListZitat();
    }

    public static ObservableList<Figur> createListFiguren() {
        JSONArray j = einlesen("src/main/resources/json/figuren.json");
        ObservableList<Figur> figurenListe =
          FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject figur = (JSONObject) j.get(i);
            Figur f = Figur.fromJson(figur);
            figurenListe.add(f);
        }
        return figurenListe;
    }

    public static ObservableList<Zitat> createListZitat() {
        JSONArray j = einlesen("src/main/resources/json/zitate.json");
        ObservableList<Zitat> zitatListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject zitat = (JSONObject) j.get(i);
            Zitat z = Zitat.fromJson(zitat);
            if(z.getDialog() != null){
                zitatListe.add(z);
            }
        }
        return zitatListe;
    }

    public static ObservableList<Film> createListFilm() {
        JSONArray j = einlesen("src/main/resources/json/filme.json");
        ObservableList<Film> filmListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject film = (JSONObject) j.get(i);
            Film f = Film.fromJson(film);
            filmListe.add(f);
        }
        return filmListe;
    }

    public void ausgebenMaiar(ObservableList<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(figur -> figur.getTyp().get() == Typ.MAIAR)
          .sorted()
          .forEach(System.out::println);
    }

    public void ausgebenHobbit(ObservableList<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(f -> f.getTyp().get() == Typ.HOBBIT && f.getGroesse() != 0)
          .sorted((o1, o2) -> {
              FigurenComparator f = new FigurenComparator();
              return f.compare(o1, o2);
          })
          .forEach(System.out::println);
    }

    public Figur findFigur(String name, ObservableList<Figur> figurList) {
        Optional<Figur> s = figurList.stream()
          .filter(fName -> (fName.getName().get()).equals(name)).findAny();
        return s.orElse(null);
    }

    public Stream<Zitat> zitatZuFigur(String name) {
        Figur figur = findFigur(name, figurenListe);
        return zitatListe.stream().filter(z -> z.getFigurId()
          .equals(figur.getId()));
    }
}
