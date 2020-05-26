#Testprotokoll
###Piraten
####Erstellen von Piraten
Es befinden sich jeweils 4 Piraten an den Haefen
1. Die Namen entsprechen den Namen in der Visualisierung.
1. Die Piraten starten am jeweils angegebenen Ort (Westland/Ostland).
####Aendern vom Zustand und Ort
Nach der angegebenen Anzahl von Ticks sollen die Piraten den Zustand aendern
. Dabei
 soll gleichzeitig der Ort in der Visualisierung gewechselt werden.
1. Herumlaufen im Westland
1. Einschiffen am Westhafen
1. Übersetzen von West nach Ost
1. Herumlaufen im Ostland
1. Einschiffen am Osthafen
1. Übersetzen von Ost nach West

* Aus den Zustaenden 2 und 6 soll nur gewechselt werden, wenn das Schiff am
   jeweiligen Hafen anliegt und das Schiff die Kapazität (3) nicht ausgereizt
    hat.
* Die Anzahl an Ticks, die ein Pirat im West-/Ostland verbringt, soll
 innerhalb der mit`setRumlaufDauerMin(int)` und `setRumlaufDauerMax(int)` in [Piratensimmulation](darstellung/Piratensimulation.java) gesetzen Grenzen liegen.
###Schiff
####Erstellen vom Schiff
Das Schiff soll im Osthafen starten.
####Aendern vom Zustand und Ort
Nach der angegebenen Anzahl von Ticks soll  das Schiff  den Zustand aendern
  Dabei soll gleichzeitig der Ort in der Visualisierung gewechselt werden.
1. Osthafen
1. Im Fluss vom Osthafen zum Westhafen
1. Westhafen
1. Im Fluss vom Westhafen zum Osthafen
