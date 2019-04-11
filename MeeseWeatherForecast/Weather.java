/*
 * Weather.java
 * Author: Aaron Meese
 * Date: 2/24/19
 * 
 * Creates a Weather object with a temperature
 * and a sky condition.
 * 
 */

enum SkyConditions { SUNNY, SNOWY, CLOUDY, RAINY }

public class Weather {
	private double temperature;
	private SkyConditions skyCondition;
	
	// Why a default if user must enter temperature?
	public Weather() {
		temperature = 70;
		this.skyCondition = SkyConditions.SUNNY;
	}
	
	public Weather(int skyCondition, double temperature) {
		this.skyCondition = SkyConditions.values()[skyCondition - 1];
		this.temperature = temperature;
	}
	
	// Is there a certain way that this is supposed to return information?
	public String toString(Weather weather) {
		// Does this not require an accessor method for private fields?
		String print = "Sky condition: " + weather.skyCondition;
		print += "\nTemperature: " + weather.temperature;
		return print;
	}
	
	public Boolean equals(Weather weather2) {
		double temp1 = this.temperature, temp2 = weather2.temperature;
		SkyConditions skyOne = this.skyCondition, skyTwo = weather2.skyCondition;
		if (temp1 == temp2) {
			if (skyOne.equals(skyTwo)) {
				return true;
			}
		}
		return false;
	}
	
	// Convert from Fahrenheit to Celsius
	public double convertToCelsius() {
		double temp = this.temperature;
		temp = (temp - 32) * 5 / 9;
		
		// Formats the temperature to two decimal places
		temp = Math.round(temp * 100.0) / 100.0;
		
		return temp;
	}
	
	// Checks whether the temperature and sky conditions entered are consistent
	public Boolean isConsistent() {
		if (this.temperature > 32 && this.skyCondition == SkyConditions.SNOWY) {
			// Snowing above freezing
			return false;
		} else if (this.temperature < 32 && this.skyCondition == SkyConditions.RAINY) {
			// Raining below freezing
			return false;
		}
		
		return true;
	}
}
