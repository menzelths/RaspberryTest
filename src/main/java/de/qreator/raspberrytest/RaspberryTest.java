package de.qreator.raspberrytest;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


public class RaspberryTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("<--Pi4J--> Programm gestarted.");
        
        final GpioController gpio = GpioFactory.getInstance();
    
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MeineLED", PinState.LOW);
  
        // Durch den pulldown-Widerstand ist der Eingang ohne Signal auf Erde gelegt. Sobald der Knopf gedrückt wird, liegt das Potential 3,3V an
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16, "Knopf", PinPullResistance.PULL_DOWN);

        myButton.addListener((GpioPinListenerDigital) (GpioPinDigitalStateChangeEvent event) -> {
            
            System.out.println(" --> GPIO-Status wurde geändert: " + event.getPin() + " = " + event.getState());
            if (event.getState() == PinState.HIGH) {
                pin.toggle();
            }
        });
    
        pin.setShutdownOptions(true, PinState.LOW);

        // Endlosschleife, kann durch Ctrl-C unterbrochen werden
        for (;;) {
            Thread.sleep(500);
        }
    }
}
