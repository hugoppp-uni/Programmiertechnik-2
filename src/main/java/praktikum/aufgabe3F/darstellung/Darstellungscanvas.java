/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3F.darstellung;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import praktikum.aufgabe3F.Beobachter;
import praktikum.aufgabe3F.ISimObjekt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Eine angepasst Zeichenfläche für die Darstellung einer Piratem-Szene.
 */
public class Darstellungscanvas extends Canvas implements Beobachter {

    /**
     * Liste aller Simulationsobjekte in der Szene.
     */
    private List<ISimObjekt> simObjekte;

    /**
     * Bild zur Darstellung eines Piraten.
     */
    private Image imagePirate;

    /**
     * Bild zur Darstellung des Schiffs.
     */
    private Image imageShip;

    /**
     * Ein internes Mapping zwischen Orten und Objekten, das verwendet wird, damit die Objekte am gleichen Ort
     * untereinander (und nicht übereinander) dargestellt werden.
     */
    private Map<ISimObjekt.Ort, Integer> cacheSimObjekteInOrt;

    public Darstellungscanvas(int breite, int hoehe, List<ISimObjekt> simObjekte) {
        super(breite, hoehe);
        this.simObjekte = simObjekte;
        this.cacheSimObjekteInOrt = new HashMap<>();

        // Beobachter verbinden
        for (ISimObjekt fahrzeug : simObjekte) {
            fahrzeug.hinzufuegen(this);
        }

        // Bilder einlesen und zwischenspeichern
        try {
            FileInputStream inputstream = new FileInputStream("src/main/resources/sprites/schiff.png");
            imageShip = new Image(inputstream);
            inputstream = new FileInputStream("src/main/resources/sprites/pirat.png");
            imagePirate = new Image(inputstream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Erste Zeichnung der Szene
        allesZeichnen();
    }

    /**
     * Zeichnet die ganze Szene
     */
    private void allesZeichnen() {
        GraphicsContext gc = getGraphicsContext2D();
        for (ISimObjekt.Ort ort : ISimObjekt.Ort.values()) {
            cacheSimObjekteInOrt.put(ort, 0);
        }
        zeichneHintergrund(gc);
        for (ISimObjekt fahrzeug : simObjekte) {
            zeichneSimObjekt(gc, fahrzeug);
        }
    }

    /**
     * Zeichnet die Hintergrundfarben (Land, Hafen, Fluss)
     */
    private void zeichneHintergrund(GraphicsContext gc) {
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, getWidth() * 0.25, getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(getWidth() * 0.25, 0, getWidth() * 0.125, getHeight());
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(getWidth() * 0.375, 0, getWidth() * 0.25, getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(getWidth() * 0.625, 0, getWidth() * 0.125, getHeight());
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(getWidth() * 0.75, 0, getWidth() * 0.25, getHeight());
    }

    /**
     * Zeichnet ein Objekt
     */
    private void zeichneSimObjekt(GraphicsContext gc, ISimObjekt fahrzeug) {
        if (fahrzeug.getTyp() == ISimObjekt.Typ.PIRAT) {
            zeichnePirat(gc, fahrzeug);
        } else if (fahrzeug.getTyp() == ISimObjekt.Typ.SCHIFF) {
            zeichneSchiff(gc, fahrzeug);
        }
        int n = cacheSimObjekteInOrt.get(getZeichenOrt(fahrzeug));
        cacheSimObjekteInOrt.put(getZeichenOrt(fahrzeug), n + 1);
    }

    /**
     * Zeichnet das Schiff.
     */
    private void zeichneSchiff(GraphicsContext gc, ISimObjekt schiff) {
        double x = getXpos(schiff);
        int y = getYpos(schiff);
        int groesse = 100;
        gc.drawImage(imageShip, x - groesse / 2, y - groesse / 2, groesse, groesse);
        zeichneZustandFortschritt(gc, x, y - 20, schiff);
    }

    /**
     * Zeichnet einen Piraten.
     */
    private void zeichnePirat(GraphicsContext gc, ISimObjekt pirat) {
        double x = getXpos(pirat);
        int y = getYpos(pirat);
        int groesse = 30;
        gc.drawImage(imagePirate, x - groesse / 2, y - groesse / 2, groesse, groesse);
        zeichneZustandFortschritt(gc, x, y - 20, pirat);
        gc.strokeText(pirat.getName(), x, y - 30);
    }

    /**
     * Ermittelt die passende y-Position für ein Objekt, sodass die Objekte untereinander erscheinen.
     */
    private int getYpos(ISimObjekt simObjekt) {
        int n = cacheSimObjekteInOrt.get(getZeichenOrt(simObjekt));
        return (n + 1) * 60;
    }

    /**
     * Zeichnet den Fortschrittsbalken für ein Objekt.
     */
    private void zeichneZustandFortschritt(GraphicsContext gc, double x, int y, ISimObjekt simObjekt) {
        float fortschritt = simObjekt.getZustand().getFortschritt();
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, 20, 10);
        gc.setFill(Color.ORANGE);
        gc.fillRect(x + 1, y + 1, 18 * fortschritt, 10 - 2);
    }

    /**
     * Ermittelt den Ort an dem ein Objekt gezeichnet wird (Pirat bei dem Schiff, wenn dessen Ort AUF-SCHIFF ist).
     */
    private ISimObjekt.Ort getZeichenOrt(ISimObjekt simObjekt) {
        if (simObjekt.getOrt() == ISimObjekt.Ort.AUF_SCHIFF) {
            return getSchiff().getOrt();
        }
        return simObjekt.getOrt();
    }


    /**
     * Liefert die horizontale Position für ein Objekt basierend auf dem Ort.
     */
    private double getXpos(ISimObjekt fahrzeug) {
        ISimObjekt.Ort ort = getZeichenOrt(fahrzeug);
        switch (ort) {
            case FLUSS:
                return getWidth() / 2;
            case OSTLAND:
                return getWidth() * 0.125;
            case WESTLAND:
                return getWidth() * 0.875;
            case OSTHAFEN:
                return getWidth() * 5.0 / 16.0;
            case WESTHAFEN:
                return getWidth() * 11.0 / 16.0;
            default:
                throw new IllegalArgumentException("Dieser Ort sollte nicht als Zeichenort verwendet werden.");
        }
    }

    /**
     * Liefert das Schiff-Objekt
     */
    private ISimObjekt getSchiff() {
        for (ISimObjekt fahrzeug : simObjekte) {
            if (fahrzeug.getTyp() == ISimObjekt.Typ.SCHIFF) {
                return fahrzeug;
            }
        }
        throw new IllegalArgumentException("Es muss ein Schiff vorhanden sein!");
    }

    @Override
    public void update(Object payload) {
        Platform.runLater(() -> allesZeichnen());
    }
}
