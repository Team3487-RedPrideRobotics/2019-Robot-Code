package net.bak3dnet.robotics.led.modules;

import net.bak3dnet.robotics.led.Color;

/**
 * Sets the channel this is assigned to a static color.
 */
public class AStaticColorModule extends LedControlModule{

    public AStaticColorModule(byte[] rgbArray) {

        red = rgbArray[0];
        green = rgbArray[1];
        blue = rgbArray[2];

    } 

    public AStaticColorModule(String hexString) {

        this(Color.stringToByteArray(hexString));

    }

    public AStaticColorModule(Color color) {
    
        this(color.getBytes());

    }

    @Override
    public void task(long deltaTime) {}



}