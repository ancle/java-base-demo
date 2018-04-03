package thread.pandc.producer;

public abstract class AbstractProducer implements Runnable, Producer {
	@Override
	public void run() {
		while (true)
			try {
				produce();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
	}

}
