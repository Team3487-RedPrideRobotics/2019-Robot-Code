package net.bak3dnet.robotics.led;

import java.util.Arrays;

import edu.wpi.first.wpilibj.SerialPort;
//import net.bak3dnet.SerialPort;
import net.bak3dnet.robotics.led.modules.LedControlModule;

public class LightDrive12 {

    private ControllerUpdatingService updatingService;
    private Thread serviceThread;

    private Channel channel1 = new Channel();
    private Channel channel2 = new Channel();
    private Channel channel3 = new Channel();
    private Channel channel4 = new Channel();

    private Channel[] channels;

    private SerialPort port;

    /**
     * The constructor for the LightDrive
     * @param portToUse The serial port that is being used by the lightdrive.
     */
    public LightDrive12(SerialPort.Port portToUse) {

        port = new SerialPort(115200, portToUse);

        channels = new Channel[4];
        channels[0] = channel1;
        channels[1] = channel2;
        channels[2] = channel3;
        channels[3] = channel4;

        updatingService = new ControllerUpdatingService(this);
        serviceThread = new Thread(updatingService, "LED Updating Service");
        serviceThread.start();

    }

    private byte calculateChecksum(byte[] toCalculate) {

        byte sum = 0;

        for(byte b: toCalculate) {

            sum +=b;

        }

        return sum;

    }

    private void writeToSerialBus() {

        byte[] dataOut = new byte[14];
        dataOut[0] = (byte) 0xAA;
        for(int i = 1; i < 5; i++) {

            dataOut[3*i-2] = channels[i-1].getColorValue('g');
            dataOut[3*i-1] = channels[i-1].getColorValue('r');
            dataOut[3*i] = channels[i-1].getColorValue('b');

        }
        
        dataOut[13] = calculateChecksum(dataOut);

        port.write(dataOut, 14);

    }

    private class ControllerUpdatingService implements Runnable {

        LightDrive12 lightDrive;
        Channel[] channels;
        long[] previousTimes = new long[4];

        public ControllerUpdatingService(LightDrive12 lDrive12) {

            lightDrive = lDrive12;
            channels = lightDrive.getChannels();

            Arrays.fill(previousTimes, System.currentTimeMillis());

        }

        @Override
        public void run() {

            while(true) {
                
                for(int i = 0; i<4;i++) {

                    long currentTimeMillis = System.currentTimeMillis();
                    long deltaTime = currentTimeMillis - previousTimes[i];
                    channels[i].updateColorValues(deltaTime);
                    previousTimes[i] = currentTimeMillis;

                }

                lightDrive.writeToSerialBus();

                try{

                    Thread.sleep(15);

                } catch(InterruptedException e) {

                    break;

                }

            }

        }

    }

    /**
     * Sets the module to set the colors.
     * 
     * @param channelId The channel to set the module.
     * @param module The module to set the channel to.
     */
    public void setChannelModule(int channelId, LedControlModule module) {

        serviceThread.interrupt();

        switch(channelId) {

            case 1: channel1.setChannelModule(module);
                break;
            case 2: channel2.setChannelModule(module);
                break;
            case 3: channel3.setChannelModule(module);
                break;
            case 4: channel4.setChannelModule(module);
                break;
            default: throw new IllegalArgumentException("There are only four channels on the device. Count naturally.");

        }

        serviceThread = new Thread(updatingService, "LED Updating Service");
        serviceThread.start();   

    }

    /**
     * Gets the channels
     * @return An array of the channels
     */
    public Channel[] getChannels() {

        return channels;

    }


}