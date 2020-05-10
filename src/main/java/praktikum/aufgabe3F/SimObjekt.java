package praktikum.aufgabe3F;

public class SimObjekt extends ISimObjekt {
    private final String name;
    private final Ort ort;
    private final Zustand zustand;
    private final Typ typ;

    public SimObjekt(String name, Ort ort, Zustand zustand, Typ typ) {
        this.name = name;
        this.ort = ort;
        this.zustand = zustand;
        this.typ = typ;
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
        return typ;
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
