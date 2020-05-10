package praktikum.aufgabe3F;

public class Pirat extends ISimObjekt{
    private String name;
    private Schiff referenzAufSchiff;
    private Ort ort;
    private Zustand zustand;
    /**
     * Liefert den Namen des Objektes für die Ausgabe.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Liefert den Ort an dem sich das Simulationsobjekt gerade befindet.
     */
    @Override
    public Ort getOrt() {
        return ort;
    }

    /**
     * Liefert den aktuellen Zustand des Objektes.
     */
    @Override
    public IZustand getZustand() {
        return zustand;
    }

    /**
     * Liefert den Typ des Objektes (u.a. für die grafische Ausgabe notwendig).
     */
    @Override
    public Typ getTyp() {
        return Typ.PIRAT;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used to
     * create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may take
     * any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
