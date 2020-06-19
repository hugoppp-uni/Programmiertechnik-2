// Seit Java9 kann man ein Java-Projekt in Module aufteilen
// Module werden dann in einer solchen Datei konfiguriert
module pmzwei {

  // Abhängigkeiten zu anderen Modulen (Import)
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires org.junit.jupiter.api;
  requires org.junit.jupiter.engine;
  requires com.google.common;
  requires org.json;
  requires org.jetbrains.annotations;

  // API des Moduls (von außen sichtbar) - hier müssen alle Packages mit Anwendungsklassen dabei sein
  // exports ist eine weitere Sichtbarkeitsebene über private/protected/public (Export)
  exports vorlesungsuebungen.vorlesung08.uebung2;
  exports vorlesungsuebungen.vorlesung08.uebung3;
  exports vorlesungsuebungen.vorlesung08.uebung4;
  exports vorlesungsuebungen.vorlesung08.uebung6;
  exports vorlesungsuebungen.vorlesung08.uebung7;
  exports vorlesungsuebungen.vorlesung09.uebung3_4_5_6;
  exports vorlesungsuebungen.vorlesung09.uebung7;
  exports praktikum.aufgabe2H;
  exports praktikum.aufgabe2FkeineAbgabe;
  exports praktikum.aufgabe3H;
  exports praktikum.aufgabe3H.darstellung;
  exports praktikum.aufgabe3F;
  exports praktikum.aufgabe3F.darstellung;
  exports praktikum.aufgabe4H;
  exports praktikum.aufgabe4F;

}