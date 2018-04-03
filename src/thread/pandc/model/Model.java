package thread.pandc.model;

public interface Model {
	public Runnable newConsumer();
	
	public Runnable newProducer();
}
