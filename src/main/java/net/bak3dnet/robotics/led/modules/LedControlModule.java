package net.bak3dnet.robotics.led.modules;

/**
 * @author Jacob Armstrong
 * 
 * This class encapsulates what controls the leds. The purpose of this class is to give
 * developers mostly full control over their led strips.
 */
public abstract class LedControlModule {

    protected byte red;
    protected byte green;
    protected byte blue;

    /**
     * The recommended way of updating your stip.
     * If, for some reason, you want just one of the colors, see {@link #task(long)} and any one of the single color methods.
     * 
     * @param deltaTime The change in time since the last time the method has been called
     * @return The array of RGB values to be on the strip.
     */
    public byte[] updateColorData(long deltaTime) {

        task(deltaTime);
        byte[] out = {red, green, blue};
        return out;

    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
    }

    /**
     * This method is called every time the rgb is to be updated. 
     * 
     * @param deltaTime The change in time since the last time this method was called.
     */
    protected abstract void task(long deltaTime);
}