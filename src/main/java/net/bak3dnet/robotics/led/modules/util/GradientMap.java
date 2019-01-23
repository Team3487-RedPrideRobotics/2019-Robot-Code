package net.bak3dnet.robotics.led.modules.util;

import java.util.HashMap;
import java.util.Map;

import net.bak3dnet.robotics.led.Color;
/**
 * A map for storing positions of colors for a gradient.
 */
public class GradientMap {

    private Map<Integer, Color> colors = new HashMap<Integer, Color>();
    private Map<Integer, Long> points = new HashMap<Integer, Long>();

    private Long durationOfMapMillis = 0L;

    public GradientMap(Color color, Long lengthAfterLastColor) {

        colors.put(0,color);
        points.put(0,lengthAfterLastColor);

    }

    public GradientMap() {}

    /**
     * Appends the color to the gradient.
     * @param color The color to be appended.
     * @param lengthAfterLastColor How many milliseconds after the previous color.
     */
    public void put(Color color, Long lengthAfterLastColor) {

        colors.put(colors.size(), color);
        points.put(points.size(), lengthAfterLastColor);

        durationOfMapMillis += lengthAfterLastColor;

    }

    /**
     * Puts a color at the index, replacing the color at the current index.
     * @param color The color to put.
     * @param lengthAfterLastColor The milliseconds after the previous color.
     * @param index The index to put the color.
     */
    public void put(Color color, Long lengthAfterLastColor, Integer index) {

        if(index > colors.size()) {

            throw new IllegalArgumentException("Please make sure the colors are in numerical order.");

        }

        colors.put(index, color);
        points.put(index, lengthAfterLastColor);
        lengthAfterLastColor += lengthAfterLastColor;

    }

    /**
     * Puts a color at the index, and shifts the next colors back.
     * 
     * @param color The color to insert.
     * 
     * @param lengthAfterLastColor The time in milliseconds to wait after the previous color
     * 
     * @param index The index to insert the color.
     */
    public void insert(Color color, Long lengthAfterLastColor, Integer index) {

        Color prevColor;
        Color currentColor = color;
        Long prevTime;
        Long currentTime = lengthAfterLastColor;
        for(int i = index; i < colors.size(); i++){

            prevColor = colors.get(i);
            prevTime = points.get(i);
            colors.put(i, currentColor);
            points.put(i, currentTime);
            currentColor = prevColor;
            currentTime = prevTime;            

        }

    }

    private int getColorDelta(int nextColor, int previousColor, long lengthBtwnColors, long transitive) {

      double numerator = nextColor - previousColor;

      double delta = numerator / lengthBtwnColors;

      float position = (float) ((double)delta*transitive);

      int finalOut = (int) Math.round(position);

      return finalOut + previousColor;

    }

    /**
     * Gets the color from the position in milliseconds.
     * @param positionInMilliseconds The time in milliseconds the module has been active.
     * @return A new color with the gradient applied.
     */
    public Color getCurrentColor(double positionInMilliseconds) {

      int pointInGradient = (int) (positionInMilliseconds % duration());

      int pIGBackup = pointInGradient;

      int preSub = 0;
      int futureColorId = 0;

      while(pIGBackup > 0) {

        preSub = pIGBackup;
        pIGBackup -= points.get(futureColorId);
        futureColorId++;

      }

      int prevColorId;
      if(futureColorId == 0) {

        prevColorId = colors.size()-1;

      } else {
          prevColorId = futureColorId-1;
      }


      int currentRed = getColorDelta(colors.get(futureColorId).getRed(), colors.get(prevColorId).getRed(), points.get(futureColorId), (long)preSub);
      int currentGreen = getColorDelta(colors.get(futureColorId).getGreen(), colors.get(prevColorId).getGreen(), points.get(futureColorId), (long)preSub);
      int currentBlue = getColorDelta(colors.get(futureColorId).getBlue(), colors.get(prevColorId).getBlue(), points.get(futureColorId), (long)preSub);
      
      return new Color(currentRed,currentGreen,currentBlue);

    }

    /**
     * Removes the color at the index.
     * @param index The index to remove.
     */
    public void remove(int index) {

        durationOfMapMillis -= points.get(index);

        for(int i = index; i < colors.size(); i++) {

            if(colors.get(i+1) != null) {
                colors.put(i, colors.get(i+1));
                points.put(i, points.get(i+1));
            } else {
                colors.remove(i);
                points.remove(i);
                break;
            }
        }

    }
    /**
     * Gets the size of the Gradient.
     * @return Integer of size of the gradient.
     */

    public int size() {

        return colors.size();

    }

    /**
     * The duration of the gradient if the scale was set to one (1).
     * @return The length in milliseconds of the gradient.
     */
    public long duration() {

        return durationOfMapMillis;

    }
    
    /**
     * Gets the color at the index.
     * @param index The index of the color, starting at 0.
     * @return The color at the index
     */

    public Color getColor(int index) {

        if(!colors.containsKey(index)) {
            return null;
        }
        return colors.get(index);

    }

}
