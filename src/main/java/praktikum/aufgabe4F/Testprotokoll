#Testprotokoll
####Erstellen der GUI
Es werden drei Tabellen sowie ein Textfeld und ein Label erzeugt. Die Tabellen tragen die Namen, die in der Visualisierung
zu sehen sind. Das Label beschriftet das Textfeld.
Die GUI wird mit einer VBOX und in dieser mit mehreren HBOXen initialisiert.
####Befüllen mit Daten
Die Tabellen werden mithilfe aus jeweiligen Funktionen, also  `createListFiguren()`, `createListZitat()` und `createListFilm()`
aus [HerrDerRingeDaten](/praktikum/aufgabe2FkeineAbgabe/HerrDerRingeDaten.java) hergestellten Listen mit Figuren, Zitaten 
oder Filmen befüllt.
####Ändern der Daten
Es werden bei der Tabelle mit Figuren und bei der Tabelle mit Filmen einen **ChangeListener** auf das ausgewählte Item 
registriert.
Bei der Figuren-Tabelle wird die Funktion `zitatZuFigur(String)` aus 
[HerrDerRingeDaten](/praktikum/aufgabe2FkeineAbgabe/HerrDerRingeDaten.java) aufgerufen und die zurückgegebene Liste
der Zitat-Tabelle zugewiesen.
Bei der Film-Tabelle wird sich das ausgewählte Item aus der Figuren-Tabelle geholt und die Funktion `zitatZuFilmFigur(Figur, ObservableList<Zitat>)`
damit sowie mit einer Liste von Zitaten, erschaffen von der Funktion `zitatZuFilm(String)`, aufgerufen. Die zurückgegebene Liste
wird der Zitat-Tabelle zugewiesen.
Dem Textfeld wird ein **EventHandler** zugewiesen, der mit **Regular Expressions** arbeitet um die richtige Syntax und 
Eingabe zu erkennen und sie an die Funktionen `findFigurName(String, ObservableList<Figur>)` oder `findFigurTyp(String, 
ObservableList<Figur>)` weiterzugeben. Die Ergebnisse werden in der Figuren-Tabelle angezeigt.