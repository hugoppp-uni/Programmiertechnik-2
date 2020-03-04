package praktikum.aufgabe3;

/**
 * Schnittstelle für die Implementierung des Zustands.
 */
public interface IZustand {
    /**
     * Liefert den aktuellen Fortschritt innerhalb des Zustandes.
     */
    float getFortschritt();

    /**
     * Führt den Zustand einen Schritt weiter.
     */
    IZustand tick();

    /**
     * Setzt den Zustand zurück auf den Anfangszustand.
     */
    void reset();
}
