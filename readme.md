# Readme zur Vorgabe PM2

## Einrichten

### Projekt importieren

IntelliJ -> Import -> Gradle

### Build, Ausführen und Testen über IntelliJ

IntelliJ -> Preferences -> Build/Execution/Deployment -> Build Tools -> Gradle

* Build and run using: IntelliJ (nicht Gradle)
* Run tests using: IntelliJ (nicht Gradle)

## Java Modularisierung

Dieses Projekt verwendet die in Java9 einführte Modularisierung ([dieser 
Artikel](https://www.informatik-aktuell.de/entwicklung/programmiersprachen/modulare-anwendungen-mit-java.html)
bietet u.a. einen guten Einstieg in das Thema). 
Auf die Entwicklung einzelner Klassen hat das zunächst keinen Einfluss. 
Grund für die Verwendung ist, dass damit das Ausführen von 
JavaFX-Anwendungen einfacher ist. Ohne die Modularisierung müsste
beim erstmaligen Starten einer ausführbaren JavaFX-Anwendung noch 
ein komplexer VM-Parameter manuell angegeben werden. Einen Einfluss hat 
die Verwendung der Modularisierung aber bei Abhängigkeiten. So muss 
in der Modulbeschreibung explizit noch einmal angegeben werden, 
welche Funktionalität in das Modul importiert und von dort exportiert 
werden muss. 

Eigentlich sollten im Verlauf des Semesters keine nachträglichen 
Änderungen in der Moduldeklaration notwendig sein. Diese Deklaration
findet man in der Datei *module_info.java* unter src/main/java. Wenn 
eigene Packages mit JavaFX-Anwendungen angelegt werden, dann müssen 
diese auch in der Datei zum Export gekennzeichnet werden. 