package patterns.observer;

public class MainClass {
 	
	public static void main(String[] args) {
		
		GoogleWeather googleWeather = new GoogleWeather();
		AccuWeather accuWeather = new AccuWeather();
		
		WeatherData weatherData = new WeatherData();
		weatherData.addSubscriber(googleWeather);
		weatherData.addSubscriber(accuWeather);
		
		weatherData.setWeather(43, 12, 11);
	}
}
