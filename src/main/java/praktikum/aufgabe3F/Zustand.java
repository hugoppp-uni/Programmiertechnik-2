package praktikum.aufgabe3F;

public class Zustand implements IZustand {
    private String name;
    private int dauer;
    private int zeitImZustand;
    private Zustand nachfolgeZustand;
    private ISimObjekt simObjekt;
    private Runnable onReset;

    public Zustand(ISimObjekt simObjekt, String name, int dauer,
                   Runnable onReset) {
        this.name = name;
        this.dauer = dauer;
        this.simObjekt = simObjekt;
        this.onReset = onReset;
        this.zeitImZustand = 0;
    }

    public void setNachfolgeZustand(Zustand neuerZustand){
        this.nachfolgeZustand = neuerZustand;
    }

    /**
     * Liefert den aktuellen Fortschritt innerhalb des Zustandes.
     */
    @Override
    public float getFortschritt() {
        return dauer-zeitImZustand;
    }

    /**
     * Führt den Zustand einen Schritt weiter.
     */
    @Override
    public Zustand tick() {
        zeitImZustand++;
        if(zeitImZustand < dauer) {
            return this;
        }
        nachfolgeZustand.reset();
        return nachfolgeZustand;
    }

    /**
     * Setzt den Zustand zurück auf den Anfangszustand.
     */
    @Override
    public void reset() {
        onReset.run();
    }

    @Override
    public String toString() {
        return "Zustand{" +
          "name='" + name + '\'' +
          ", dauer=" + dauer +
          ", zeitImZustand=" + zeitImZustand +
          ", nachfolgeZustand=" + nachfolgeZustand +
          ", simObjekt=" + simObjekt +
          ", onReset=" + onReset +
          '}';
    }
}
