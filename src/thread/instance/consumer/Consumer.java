package thread.instance.consumer;

import thread.instance.depot.Depot;

public class Consumer {
	private Depot depot;
	
	public Consumer(Depot depot) {
		this.depot = depot;
	}
	
	public void consume(final int value) {
		new Thread() {
			public void run() {
				try {
					depot.consume(value);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
