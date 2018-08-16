package patterns.observer;

public interface WeatherDataUpdateSubscriber {
	public void onUpdate(WeatherData weatherData);
}
