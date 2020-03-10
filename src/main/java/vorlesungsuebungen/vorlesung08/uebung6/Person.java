/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung08.uebung6;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Eine Person in einem X-Man-Film setzt sich aus Vorname, Nachname und Alias zusammen. Alle diese Eigenschaften
 * sind als Properties umgesetzt.
 *
 * @author Philipp Jenke
 */
public class Person {

    /**
     * Vorname der Person
     */
    private StringProperty vorname;

    /**
     * Nachname der Person
     */
    private StringProperty nachname;

    /**
     * Alias im X-Men-Szenario
     */
    private StringProperty alias;

    public Person(String alias, String vorname, String nachname) {
        setAlias(alias);
        setVorname(vorname);
        setNachname(nachname);
    }

    public final void setVorname(String wert) {
        vornameProperty().set(wert);
    }

    public final String getVorname() {
        return vornameProperty().get();
    }

    public StringProperty vornameProperty() {
        if (vorname == null) {
            vorname = new SimpleStringProperty();
        }
        return vorname;
    }

    public final void setNachname(String wert) {
        nachnameProperty().set(wert);
    }

    public final String getNachname() {
        return nachnameProperty().get();
    }

    public StringProperty nachnameProperty() {
        if (nachname == null) {
            nachname = new SimpleStringProperty();
        }
        return nachname;
    }

    public final void setAlias(String wert) {
        aliasProperty().set(wert);
    }

    public final String getAlias() {
        return aliasProperty().get();
    }

    public StringProperty aliasProperty() {
        if (alias == null) {
            alias = new SimpleStringProperty();
        }
        return alias;
    }
}
