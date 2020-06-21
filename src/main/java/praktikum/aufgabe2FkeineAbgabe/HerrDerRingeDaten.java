package praktikum.aufgabe2FkeineAbgabe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static praktikum.aufgabe2FkeineAbgabe.ReadingJSON.*;

/**
 * Erstellung der HerrDerRinge-Datensätzen
 */
public class HerrDerRingeDaten {
    private final ObservableList<Figur> figurenListeStatic =
      createListFiguren();
    private final ObservableList<Zitat> zitatListeStatic =
      createListZitat();
    private final ObservableList<Film> filmListeStatic =
      createListFilm();

    public ObservableList<Figur> createListFiguren() {
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

    public ObservableList<Zitat> createListZitat() {
        JSONArray j = einlesen("src/main/resources/json/zitate.json");
        ObservableList<Zitat> zitatListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject zitat = (JSONObject) j.get(i);
            Zitat z = Zitat.fromJson(zitat);
            if (z.dialogProperty() != null) {
                zitatListe.add(z);
            }
        }
        return zitatListe;
    }

    public ObservableList<Film> createListFilm() {
        JSONArray j = einlesen("src/main/resources/json/filme.json");
        ObservableList<Film> filmListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject film = (JSONObject) j.get(i);
            Film f = Film.fromJson(film);
            filmListe.add(f);
        }
        return filmListe;
    }

    /*public void ausgebenMaiar(ObservableList<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(figur -> figur.typProperty().get() == Typ.MAIAR)
          .sorted()
          .forEach(System.out::println);
    }

    public void ausgebenHobbit(ObservableList<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(f -> f.typProperty().get() == Typ.HOBBIT && f.getGroesse()
        != 0)
          .sorted((o1, o2) -> {
              FigurenComparator f = new FigurenComparator();
              return f.compare(o1, o2);
          }).forEach(System.out::println);
    }*/

    /**
     * findet Figur zu name in figurList
     *
     * @param name Name, der zu suchenden Figur
     * @param figurList Liste, in der gesucht wird
     * @return Figur zu name
     */
    public Figur findFigur(String name,
                           ObservableList<Figur> figurList) {
        Optional<Figur> s = figurList.stream()
          .filter(fName -> (fName.getName()).equals(name)).findAny();
        return s.orElse(null);
    }

    /**
     * findet mehrere Figuren zu name durch regex in figurList
     *
     * @param name Name, der zu suchenden Figuren
     * @param figurList Liste, in der gesucht wird
     * @return Figuren zu name
     */
    public ObservableList<Figur> findFigurName(String name,
                                               ObservableList<Figur> figurList) {
        ObservableList<Figur> filteredFigurList =
          FXCollections.observableArrayList();
        for (Figur strings : figurList) {
            Pattern pattern = Pattern.compile(name.toLowerCase());
            Matcher matcher = pattern.matcher(strings.getName().toLowerCase());
            if (matcher.find()) {
                filteredFigurList.add(strings);
            }
        }
        return filteredFigurList;
    }

    /**
     * findet Figuren zu typ in figurList
     *
     * @param typ Typ, der zu suchenden Figuren
     * @param figurList Liste, in der gesucht wird
     * @return Figuren zu typ
     */
    public ObservableList<Figur> findFigurTyp(String typ,
                                              ObservableList<Figur> figurList) {
        return figurList.filtered(figur -> String.valueOf(figur.getTyp()).equals(typ));
    }

    /**
     * findet Film zu titel in filmListe
     *
     * @param titel Titel, des zu suchenden Films
     * @param filmListe Liste, in der gesucht wird
     * @return Film zu titel
     */
    public Film findFilm(String titel,
                          ObservableList<Film> filmListe) {
        Optional<Film> s = filmListe.stream()
          .filter(fTitel -> (fTitel.getTitel()).equals(titel)).findAny();
        return s.orElse(null);
    }

    /**
     * findet die Zitate zu name einer Figur
     *
     * @param name Name, der Figur, die die Zitate spricht
     * @return Zitate zu name von Figur
     */
    public ObservableList<Zitat> zitatZuFigur(String name) {
        Figur figur;
        try {
            figur = findFigur(name, figurenListeStatic);
        } catch (NullPointerException e) {
            return null;
        }
        return zitatListeStatic.filtered(z -> z.getFigurId().equals(figur.getId()));
    }

    /**
     * findet Zitate zu titel eines Film
     *
     * @param titel Titel, des Films, aus dem die Zitate stammen
     * @return Zitate zu titel von Film
     */
    public ObservableList<Zitat> zitatZuFilm(String titel) {
        Film film;
        try {
            film = findFilm(titel, filmListeStatic);
        } catch (Exception e) {
            return null;
        }
        return zitatListeStatic.filtered(z -> z.getFilmId().equals(film.getId()));
    }

    /**
     * findet Zitate zu einer Figur
     * @param figur Figur, die die Zitate spricht
     * @param zitatObservableList Liste, in der gesucht wird
     * @return Zitate von figur aus zitatObservableList
     */
    public ObservableList<Zitat> zitatZuFilmFigur(Figur figur,
                                                  ObservableList<Zitat> zitatObservableList) {
        return zitatObservableList.filtered(zitat ->
          zitat.getFigurId().equals(figur.getId()));
    }
}
