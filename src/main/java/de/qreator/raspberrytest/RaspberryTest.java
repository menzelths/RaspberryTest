/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author thomas
 */
public class RaspberryTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("<--Pi4J--> Programm gestarted.");
        
        final GpioController gpio = GpioFactory.getInstance();
    
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
  
        // Durch den pulldown-Widerstand ist der Eingang ohne Signal auf Erde gelegt. Sobald der Knopf gedrückt wird, liegt das Potential 3,3V an
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16, "Knopf", PinPullResistance.PULL_DOWN);

        myButton.addListener((GpioPinListenerDigital) (GpioPinDigitalStateChangeEvent event) -> {
            
            System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            if (event.getState() == PinState.HIGH) {
                pin.toggle();
            }
        });
    
        pin.setShutdownOptions(true, PinState.LOW);

        for (;;) {
            Thread.sleep(500);
        }
        
        //gpio.shutdown();
    }
}
