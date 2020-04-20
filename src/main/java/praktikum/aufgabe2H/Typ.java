/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe2H;

/**
 * Aufwählungstyp für die verfügbaren Typen.
 */
public enum Typ {
    MENSCH,
    ELB,
    ZWERG,
    HOBBIT,
    MAIAR,
    ENT,
    ORC,
    GROSSE_SPINNE,
    DRACHE,
    AINUR,
    RABE,
    WERWOLF,
    HALB_ELB,
    ADLER,
    RINGGEIST,
    GOTT,
    WOLFSHUND,
    PFERD,
    STEINTROLL,
    VAMPIR,
    UNDEFINED;

    /**
     * Liefert die Konstante für einen String. Einige Typen aus der JSON-Datei, die den gleichen Typ beschreiben werden
     * hier gleich zusammengefasst. Liefert null, wenn keine passende Konstante gefunden wurde.
     */
    public static Typ from(String text) {
        switch (text) {
            case "Human":
            case "Man":
            case "Men":
                return MENSCH;
            case "Elf":
                return ELB;
            case "Dwarf":
            case "Dwarves":
                return ZWERG;
            case "Hobbit":
            case "Hobbits":
                return HOBBIT;
            case "Maiar":
            case "Maiar,Balrogs":
            case "Balrog":
                return MAIAR;
            case "Elves":
                return ELB;
            case "Ent":
            case "Ents":
                return ENT;
            case "Orcs":
            case "Goblin,Orc":
            case "Orc":
            case "Uruk-hai":
            case "Uruk-hai,Orc":
            case "Urulóki":
            case "Orc,Goblin":
                return ORC;
            case "Great Spiders":
                return GROSSE_SPINNE;
            case "Black Uruk":
                return ORC;
            case "Dragons":
            case "Dragon":
                return DRACHE;
            case "Ainur":
                return AINUR;
            case "Raven":
                return RABE;
            case "Werewolves":
                return WERWOLF;
            case "Half-elven":
                return HALB_ELB;
            case "Eagle":
            case "Eagles":
            case "Great Eagles":
                return ADLER;
            case "Men,Wraith":
                return RINGGEIST;
            case "God":
                return GOTT;
            case "Wolfhound":
                return WOLFSHUND;
            case "Horse":
                return PFERD;
            case "Stone-trolls":
                return STEINTROLL;
            case "Vampire":
                return VAMPIR;

            default:
                if (text.length() > 0) {
                    System.out.println("Undefinierter Typ: " + text);
                }
                return null;
        }
    }
}
