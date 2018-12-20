# TeamLiga~Console
TeamLiga~Console für Karopapier.de

Die TeamLiga~Console übernimmt Aufgaben rund um die TeamLiga auf karopapier.de und ist eine Java-Consolen-Application.
Der erste Stand wurde mobil mit "AIDE" geschrieben, wurde aber angepasst für allgemeine CLI mit OpenJDK.

Aktuelle Funktionen:
+ Spielauswertung nach GID

geplante Funktionen:
+ Spielerstellung
+ Login mit Bot-Account
+ Teams erstellen/speichern
+ Erstellung der Spielliste pro Saison
+ Nachricht an KaroChat senden
+ Dateien Erstellen, bearbeiten und speichern (DropBox, oder FTP-Zugang)

Verwendetes JSON-Package:
https://github.com/stleary/JSON-java

Compilieren innerhalb des src Ordners:
+ javac -cp .:./lib/json-20180813.jar Main.java

Ausführen innerhalb des src Ordners:
+ java -cp .:./lib/json-20180813.jar Main

Nutzung auf Android Geräten:
+ installiere Termux via GooglePlay
+ installiere ArchLinux in Termux (https://github.com/sdrausty/termux-archlinux)
+ initialisiere pacman in ArchLinux (siehe Links am ende des Abschnitts)
+ installiere OpenJDK in ArchLinux via pacman
Sollte es mit pacman anfangs Probleme geben können folgende Links helfen:
https://bbs.archlinux.de/viewtopic.php?id=28800

https://bbs.archlinux.org/viewtopic.php?id=143337
pacman-key --init
pacman-key --populate archlinuxarm (wenn in Termux installiert)


Hinweis: Programmierkenntnisse habe ich mir selber angeeignet.
Daher ist der Code nicht unbedingt der beste.
Verbesserungsvorschläge nehme ich gerne an.
