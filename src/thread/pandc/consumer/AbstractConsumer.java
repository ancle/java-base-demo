package thread.pandc.consumer;

public abstract class AbstractConsumer implements Runnable, Consumer {

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

}
