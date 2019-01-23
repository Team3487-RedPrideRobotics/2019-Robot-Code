package net.bak3dnet.robotics.led;

import net.bak3dnet.robotics.led.modules.LedControlModule;
import net.bak3dnet.robotics.led.modules.AStaticColorModule;

public class Channel {

    private byte redValue;
    private byte greenValue;
    private byte blueValue;

    private LedControlModule activeModule;

    public Channel() {

        redValue = greenValue = blueValue = 0;
        activeModule = new AStaticColorModule("000");

    }

    /**
     * Gets the brightnes of the color ids.
     * 
     * @param colorId The color id, 'r', 'g', 'b'
     * 
     * @return sRGB byte array
     */
    public byte getColorValue(char colorId) {

        switch(colorId) {

            case 'r':
                return redValue;
            case 'g':
                return greenValue;
            case 'b':
                return blueValue;
            default: throw new IllegalArgumentException("The only color IDs are r, g, and b");

        }

    }

    /**
     * Gets the latest color.
     * 
     * @param deltaTime The length of time since last run.
     */
    public void updateColorValues(long deltaTime) {

        byte[] data = activeModule.updateColorData(deltaTime);

        redValue = data[0];
        greenValue = data[1];
        blueValue = data[2];

    }

    /**
     * Sets the channel's module
     * @param module The module to set the channel to
     */
    public void setChannelModule(LedControlModule module) {

        activeModule = module;

    }

    /**
     * Gets the active module.
     * @return The active module.
     */
    public LedControlModule getChannelModule() {

        return activeModule;

    }

}