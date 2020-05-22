package praktikum.aufgabe3F;

public class Schiff extends ISimObjekt {
    private String name;
    private Zustand zustand;
    private Ort ort;
    private int kapazitaet;
    private int aktuelleBeladung;

    public Schiff(String name, int kapazitaet) {
        Zustand z1 = new Zustand(this, "Osthafen", 5,
          () -> setOrtAndNotifyAll(Ort.OSTHAFEN));
        Zustand z2 = new Zustand(this, "Im Fluss vom Osthafen zum Westhafen",
          10, () -> setOrtAndNotifyAll(Ort.FLUSS));
        Zustand z3 = new Zustand(this, "Westhafen", 5,
          () -> setOrtAndNotifyAll(Ort.WESTHAFEN));
        Zustand z4 = new Zustand(this, "Im Fluss vom Westhafen zum Osthafen",
          10, () -> setOrtAndNotifyAll(Ort.FLUSS));

        z1.setNachfolgeZustand(z2);
        z2.setNachfolgeZustand(z3);
        z3.setNachfolgeZustand(z4);
        z4.setNachfolgeZustand(z1);

        this.name = name;
        this.zustand = z1;
        this.ort = Ort.OSTHAFEN;
        this.kapazitaet = kapazitaet;
        this.aktuelleBeladung = 0;
    }

    public void setOrtAndNotifyAll(Ort ort) {
        this.ort = ort;
        this.notifyAll();
    }

    public synchronized void einschiffen(Pirat pirat) {
        while (this.ort != pirat.getOrt() || aktuelleBeladung >= kapazitaet) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        aktuelleBeladung++;
    }

    public synchronized void ausschiffen(Pirat pirat, Ort ort) {
        while (ort != this.ort || aktuelleBeladung >= kapazitaet) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        aktuelleBeladung--;
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
    public Zustand getZustand() {
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
        while(true){
            zustand.tick();
            try {
                Thread.sleep(300);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            melden();
        }
    }
}
