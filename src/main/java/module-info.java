// Seit Java9 kann man ein Java-Projekt in Module aufteilen
// Module werden dann in einer solchen Datei konfiguriert
module hawhamburg {

    // Abhängigkeiten zu anderen Modulen
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.junit.jupiter.api;
    requires com.google.common;
    requires org.json;

    // Namens-Mapping
    opens vorlesungsuebungen.vorlesung08.uebung2 to javafx.fxml;

    // API des Moduls (von außen sichtbar) - hier müssen alle Packages mit Anwendungsklassen dabei sein
    // exports ist eine weitere Sichtbarkeitsebene über private/protected/public
    exports vorlesungsuebungen.vorlesung08.uebung2;
    exports vorlesungsuebungen.vorlesung08.uebung3;
    exports vorlesungsuebungen.vorlesung08.uebung4;
    exports vorlesungsuebungen.vorlesung08.uebung6;
    exports vorlesungsuebungen.vorlesung08.uebung7;
    exports vorlesungsuebungen.vorlesung09.uebung3_4_5_6;
    exports vorlesungsuebungen.vorlesung09.uebung7;
    exports praktikum.aufgabe3.darstellung;
    exports praktikum.loesung.aufgabe3;
    exports praktikum.loesung.aufgabe4;
}