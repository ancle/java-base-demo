package thread.pandc.test;

import thread.pandc.model.Model;
import thread.pandc.model.impl.BlockingQueueModel;

public class BlockingQueueTest {

	public static void main(String[] args) {
		Model model = new BlockingQueueModel(3);
		
		for (int i = 0; i < 2; i++) {
			new Thread(model.newProducer()).start();
		}
		
		for (int i = 0; i < 3; i++) {
			new Thread(model.newConsumer()).start();
		}
	}

}
