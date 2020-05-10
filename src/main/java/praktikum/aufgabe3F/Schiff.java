package praktikum.aufgabe3F;

public class Schiff extends ISimObjekt {
    private String name;
    private Zustand zustand;
    private Ort ort;
    private int kapazität;
    private int aktuelleBeladung;

    public synchronized void einschiffen(Pirat pirat) {

    }

    public synchronized void ausschiffen(Pirat pirat, Ort ort) {

    }

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
        return Typ.SCHIFF;
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
