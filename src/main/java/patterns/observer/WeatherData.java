package patterns.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class WeatherData {
	
	double temp;
	double humidity;
	double pressure;
	
	
	private ArrayList<WeatherDataUpdateSubscriber> subscribers = new ArrayList<>();
	
	public void addSubscriber(WeatherDataUpdateSubscriber subscriber) {
		if(subscriber==null)
			throw new NullPointerException("displayDevice is null");
		else if(!subscribers.contains(subscriber))
			subscribers.add(subscriber);
	}
	
	public void removeSubscriber(WeatherDataUpdateSubscriber subscriber) {
		subscribers.remove(subscriber);
	}
	
	
	public double getTemp() {
		return temp;
	}
	
	public double getHumid() {
		return humidity;
	}
	
	public double getAirPressure() {
		return pressure;
	}
	
	/**
	 * Gets called whenever there is a change in weather statistics
	 */
	public void weatherChanged() {
		// Let's notify observers first
		for(Iterator<WeatherDataUpdateSubscriber> iterator = subscribers.iterator(); iterator.hasNext();) {
			WeatherDataUpdateSubscriber displayDevice = iterator.next();
			displayDevice.onUpdate(this);
		}
	}
	
	public void setWeather(double temp, double humidity, double pressure) {
		this.temp=temp;
		this.humidity=humidity;
		this.pressure=pressure;
		weatherChanged();
	}
}
