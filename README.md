## RaspberryTest mit PI4J
Ein einfacher Test des Raspberry Pi 2 mit Input und Output, wobei die Ansteuerung über PI4J erfolgt.

Damit das Programm auf dem Raspberry Pi funktioniert, muss dort PI4J installiert sein (siehe Anleitung auf der [Projektseite von PI4J](http://pi4j.com/)). 

Die Bibliothek PI4J wird beim Build-Prozess von Maven bereits in der Uber-Jar mitgeliefert, so dass das Programm auf dem Raspberry ohne einen weiteren Klassenpfad aufgerufen werden kann: ins Verzeichnis wechseln, in dem sich die Jar-Datei befindet und dann starten durch

```java
sudo java -jar RaspberryTest-1.0-SNAPSHOT.jar
```

### Die Anschlüsse:
Die Pins seien im folgenden von 1 bis 40 durchnummeriert:

1 | 2

3 | 4

...


* Knopf an 3,3V (PIN 1) und RXD (PIN 10, entspricht in pi4j GPIO 16)
* LED mit Widerstand an GND und GPIO 18 (also PIN 12, entspricht in pi4j GPIO 1)

### Schaltskizze
![Raspberry-Verkabelung](https://github.com/menzelths/RaspberryTest/blob/master/src/main/resources/Raspberry_input_output_Steckplatine.png)

## Links:
- [PI4J](http://pi4j.com/)
- [Fritzing](http://fritzing.org/home/) zur Erstellung von Schaltbildern
- [Pullup- und Pulldownwiderstände](http://www.bit-101.com/blog/?p=3813) (Gute englischsprachige Erklärung)
