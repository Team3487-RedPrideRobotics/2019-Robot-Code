package net.bak3dnet.robotics.led.modules;

import net.bak3dnet.robotics.led.modules.util.GradientMap;

/**
 * Sets the channel this is set to a dynamic gradient.
 */
public class AGradientModule extends LedControlModule {

    GradientMap colors;

    double scale;

    long position;

    boolean gradientToOriginal;

    /**
     * Creates a Gradient Module
     * 
     * @param colorAndPercentage The Gradient Map with the colors.
     * 
     * @param scale The scale at which the time should be scaled to.
     * 
     * @param startAtPercent The percentage of the gradient to start at.
     */
    public AGradientModule(GradientMap colorAndPercentage, double scale, double startAtPercent) {

        if(colorAndPercentage.size() < 2) {

            throw new IllegalArgumentException("You need at least two colors to gradient.");

        }

        this.scale = scale;

        colors = colorAndPercentage;

        position = colorAndPercentage.duration() *(long) startAtPercent;

    }

    /**
     * Creates a gradient module with a gradient map.
     * @param colorAndPercentage The gradient map to use.
     */
    public AGradientModule(GradientMap colorAndPercentage) {

        this(colorAndPercentage,1D,0D);

    }

    @Override
    public byte[] updateColorData(long deltaTime) {
        position += deltaTime * (long)scale;
        //System.out.println(position);
        return colors.getCurrentColor(position).getBytes();
    }

    @Override
    public void task(long deltaTime) {}

}