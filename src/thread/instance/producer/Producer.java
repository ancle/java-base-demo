package thread.instance.producer;

import thread.instance.depot.Depot;

public class Producer {
	private Depot depot;
	
	public Producer(Depot depot) {
		this.depot = depot;
	}
	
	public void produce(final int value) {
		new Thread() {
			public void run() {
				try {
					depot.produce(value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
