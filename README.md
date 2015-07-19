## RaspberryTest mit pi4j
Ein einfacher Test des Raspberry Pi 2 mit input und output.

### Die Anschlüsse:
Die Pins seien im folgenden von 1 bis 40 durchnummeriert:

1 | 2

3 | 4

...


* Knopf an 3,3V (PIN 1) und RXD (PIN 10, entspricht in pi4j GPIO 16)
* LED mit Widerstand an GND und GPIO 18 (also PIN 12, entspricht in pi4j GPIO 1)

### Schaltskizze
![Arduino-Verkabelung](https://github.com/menzelths/firmata/blob/master/src/main/resources/FirmataMitLCD/firmataDisplay.png)
