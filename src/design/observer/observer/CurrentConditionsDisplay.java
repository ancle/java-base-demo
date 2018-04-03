package design.observer.observer;

import design.observer.subject.Subject;

public class CurrentConditionsDisplay implements Observer {
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
	}

	@Override
	public void update() {
	}

}
