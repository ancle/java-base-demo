package design.observer.subject;

import java.util.ArrayList;
import java.util.List;

import design.observer.observer.Observer;

public class WeatherData implements Subject {
	private List<Observer> observers = null;
	private String temperature;
	private String humidity;
	private String pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer observer) {
		if (null != observer) {
			observers.add(observer);
		}
	}

	@Override
	public void remObserver(Observer observer) {
		if (null != observer) {
			/*int index = observers.indexOf(observer);
			if (index != -1) {
				observers.remove(index);
			}*/
			
			if (observers.contains(observer)) {
				observers.remove(observer);
			}
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
	public void setMeasurements(String temperature, String humidity, String pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		notifyObservers();
	}
	
	public String getMeasurements() {
		return this.temperature + " : " + this.humidity + " : " + this.pressure;
	}

}
