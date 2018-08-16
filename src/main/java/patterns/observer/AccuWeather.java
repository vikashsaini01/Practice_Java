package patterns.observer;

public class AccuWeather implements DisplayDevice, WeatherDataUpdateSubscriber{

	String temperature;
	String humidity;
	String airPressure;
	float feelsLike;
	float probabilityOfRain;
	
	
	@Override
	public void display() {
		System.out.println("****Accu weather****");
		System.out.println("Temp : "+ this.temperature);
		System.out.println("Feels Like : "+this.feelsLike);
		System.out.println("Humidity : "+this.humidity+"%");
		System.out.println("Pressure : "+this.airPressure+" KM/H");
		System.out.println("Probability Of Rain : "+this.probabilityOfRain+"%");
		System.out.println();
	}

	@Override
	public void onUpdate(WeatherData weatherData) {
		this.temperature = String.valueOf(weatherData.getTemp());
		this.humidity = String.valueOf(weatherData.getHumid());
		this.airPressure = String.valueOf(weatherData.getAirPressure());
		
		this.feelsLike =computeHeatIndex(Float.parseFloat(this.temperature) , Float.parseFloat(this.airPressure));
		this.probabilityOfRain = this.feelsLike/2;
		
		this.display();
	}
	
	
	private float computeHeatIndex(float t, float rh) {
		float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
			(0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
			(0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
			(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *  
			(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
			(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +     
			0.000000000843296 * (t * t * rh * rh * rh)) -
			(0.0000000000481975 * (t * t * t * rh * rh * rh)));
		return index;
	}
}
