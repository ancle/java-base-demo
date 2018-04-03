package design.observer.subject;

import design.observer.observer.Observer;

public interface Subject {
	public void addObserver(Observer observer);
	
	public void remObserver(Observer observer);
	
	public void notifyObservers();
}
