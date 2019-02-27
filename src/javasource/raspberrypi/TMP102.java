// This file was for the most part copied from here: https://gist.github.com/markadr/63b8eaf4248f0054c241
package raspberrypi;

import java.io.IOException;

import com.pi4j.io.i2c.*;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.system.SystemInfo;
import com.pi4j.temperature.TemperatureConversion;
import com.pi4j.temperature.TemperatureScale;

public class TMP102 {

    public static final int DEVICE_ADDRESS_GROUND = 0x48;
    public static final int DEVICE_ADDRESS_VPLUS = 0x49;
    public static final int DEVICE_ADDRESS_SDA = 0x4A;
    public static final int DEVICE_ADDRESS_SCL = 0x4B;

    private I2CBus bus = null;
    private I2CDevice device = null;
    
    public TMP102(int sensorAddress) throws IOException, InterruptedException, UnsupportedBusNumberException {

        if (SystemInfo.getBoardType().equals(SystemInfo.BoardType.RaspberryPi_A)) {
            bus = I2CFactory.getInstance(I2CBus.BUS_0);
        } else {
            bus = I2CFactory.getInstance(I2CBus.BUS_1);
        }
        
        if (bus != null) {
            device = bus.getDevice(sensorAddress);
        }
    }
    
    public double getTemperature() throws IOException {
        // default is Celsius
        double result = getReadingFromDevice() * 0.0625;
        return result;
    }
    
    public void close() throws IOException {
        
        if (bus != null) {
            bus.close();
        }
    }
    
    private int getReadingFromDevice() throws IOException {

        int result = 0;

        if (device != null) {
            // http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=31272
            // http://bildr.org/2011/01/tmp102-arduino/
            byte[] tempBuffer = new byte[2];
            int bytesRead = device.read(tempBuffer, 0, 2);
            if (bytesRead == 2) {
                int MSB = tempBuffer[0] < 0 ? 256 + tempBuffer[0] : tempBuffer[0];
                int LSB = tempBuffer[1] < 0 ? 256 + tempBuffer[1] : tempBuffer[1];
                
                MSB = MSB << 4;
                LSB = LSB >> 4;
                
                result = MSB | LSB;
                // result = ((MSB << 8) | LSB) >> 4;
            }
        }
                
        return result;
    }
    
    
}
