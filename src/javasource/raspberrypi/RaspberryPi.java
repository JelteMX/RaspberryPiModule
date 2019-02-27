package raspberrypi;

import raspberrypi.proxies.Raspberry_GPIO_Port;
import raspberrypi.proxies.Raspberry_Pull_Resistance;
import raspberrypi.proxies.Temperature_Unit;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.temperature.TemperatureScale;

public class RaspberryPi {

	public static Pin getRaspberryPiPin(Raspberry_GPIO_Port port) {
		Pin pin = RaspiPin.GPIO_00;
		
		switch (port) {
		case GPIO_0: pin = RaspiPin.GPIO_00; break;
		case GPIO_1: pin = RaspiPin.GPIO_01; break;
		case GPIO_2: pin = RaspiPin.GPIO_02; break;
		case GPIO_3: pin = RaspiPin.GPIO_03; break;
		case GPIO_4: pin = RaspiPin.GPIO_04; break;
		case GPIO_5: pin = RaspiPin.GPIO_05; break;
		case GPIO_6: pin = RaspiPin.GPIO_06; break;
		case GPIO_7: pin = RaspiPin.GPIO_07; break;
		case GPIO_8: pin = RaspiPin.GPIO_08; break;
		case GPIO_9: pin = RaspiPin.GPIO_09; break;
		case GPIO_10: pin = RaspiPin.GPIO_10; break;
		case GPIO_11: pin = RaspiPin.GPIO_11; break;
		case GPIO_12: pin = RaspiPin.GPIO_12; break;
		case GPIO_13: pin = RaspiPin.GPIO_13; break;
		case GPIO_14: pin = RaspiPin.GPIO_14; break;
		case GPIO_15: pin = RaspiPin.GPIO_15; break;
		case GPIO_16: pin = RaspiPin.GPIO_16; break;
		case GPIO_17: pin = RaspiPin.GPIO_17; break;
		case GPIO_18: pin = RaspiPin.GPIO_18; break;
		case GPIO_19: pin = RaspiPin.GPIO_19; break;
		case GPIO_20: pin = RaspiPin.GPIO_20; break;
		case GPIO_21: pin = RaspiPin.GPIO_21; break;
		case GPIO_22: pin = RaspiPin.GPIO_22; break;
		case GPIO_23: pin = RaspiPin.GPIO_23; break;
		case GPIO_24: pin = RaspiPin.GPIO_24; break;
		case GPIO_25: pin = RaspiPin.GPIO_25; break;
		case GPIO_26: pin = RaspiPin.GPIO_26; break;
		case GPIO_27: pin = RaspiPin.GPIO_27; break;
		case GPIO_28: pin = RaspiPin.GPIO_28; break;
		case GPIO_29: pin = RaspiPin.GPIO_29; break;
		case GPIO_30: pin = RaspiPin.GPIO_30; break;
		case GPIO_31: pin = RaspiPin.GPIO_31; break;
		default:
			break;
		}
		
		return pin;
	}
	
	public static PinPullResistance getPullResistance(Raspberry_Pull_Resistance resistance) {
		PinPullResistance res = PinPullResistance.OFF;
		
		switch (resistance) {
		case PULL_DOWN: res = PinPullResistance.PULL_DOWN; break;
		case PULL_UP: res = PinPullResistance.PULL_UP; break;
		default:
			break;
		}
		return res;
	}
	
	public static TemperatureScale getTemperatureScale(Temperature_Unit unit) {
		TemperatureScale scale = TemperatureScale.CELSIUS;
		
		switch (unit) {
		case CELSIUS: scale = TemperatureScale.CELSIUS;
		case FARENHEIT: scale = TemperatureScale.FARENHEIT;
		case KELVIN: scale = TemperatureScale.KELVIN;
		case RANKINE: scale = TemperatureScale.RANKINE;
		default:
			break;
		}
		
		return scale;
	}
	
}

