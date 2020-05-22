package praktikum.aufgabe3F;

import java.awt.image.renderable.ContextualRenderedImageFactory;

public class Pirat extends ISimObjekt {
    private String name;
    private Schiff referenzAufSchiff;
    private Ort ort;
    private Zustand zustand;

    public Pirat(String name, Schiff referenzAufSchiff) {
        Zustand z1 = new Zustand(this, "Herumlaufen im Westland",
          3 + (int) (Math.random() * ((5 - 3) + 1)), () -> ort = Ort.WESTLAND);
        Zustand z2 = new Zustand(this, "Einschiﬀen am Westhafen", 5,
          () -> {ort = Ort.WESTHAFEN; referenzAufSchiff.einschiffen(this);});
        Zustand z3 = new Zustand(this, "Übersetzen von West nach Ost", 10,
          () -> {ort = Ort.AUF_SCHIFF; referenzAufSchiff.ausschiffen(this, Ort.OSTHAFEN);});
        Zustand z4 = new Zustand(this, "Herumlaufen im Ostland",
          3 + (int) (Math.random() * ((5 - 3) + 1)), () -> ort = Ort.OSTLAND);
        Zustand z5 = new Zustand(this, "Einschiffen am Osthafen", 5,
          () -> {ort = Ort.OSTHAFEN; referenzAufSchiff.einschiffen(this);});
        Zustand z6 = new Zustand(this, "Übersetzen von Ost nach West", 10,
          () -> {ort = Ort.AUF_SCHIFF; referenzAufSchiff.ausschiffen(this, Ort.WESTHAFEN);});

        z1.setNachfolgeZustand(z2);
        z2.setNachfolgeZustand(z3);
        z3.setNachfolgeZustand(z4);
        z4.setNachfolgeZustand(z5);
        z5.setNachfolgeZustand(z6);
        z6.setNachfolgeZustand(z1);

        this.name = name;
        this.referenzAufSchiff = referenzAufSchiff;
        this.ort = Ort.WESTLAND;
        this.zustand = z1;
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
        while (true) {
            zustand = zustand.tick();
            melden();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
