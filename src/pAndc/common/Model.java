package pAndc.common;

public interface Model {
	public Runnable newConsumer();
	
	public Runnable newProducer();
}
