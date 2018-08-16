package patterns.observer;

public class GoogleWeather implements DisplayDevice, WeatherDataUpdateSubscriber{
	
	int temp;
	int humidity;
	int pressure;
	
	@Override
	public void display() {
		System.out.println("****Google weather shows all values in whole numbers****");
		System.out.println("Temp : "+ this.temp);
		System.out.println("Humidity : "+this.humidity+"%");
		System.out.println("Pressure : "+this.pressure+" KM/H");
		System.out.println();
	}

	@Override
	public void onUpdate(WeatherData weatherData) {
		this.temp = (int)weatherData.getTemp();
		this.humidity =(int) weatherData.getHumid();
		this.pressure = (int)weatherData.getAirPressure();
		this.display();
	}
	
}
