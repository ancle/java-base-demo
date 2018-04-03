package thread.pandc.test;

import thread.pandc.model.Model;
import thread.pandc.model.impl.LockConditionModel;

public class LockConditionTest {

	public static void main(String[] args) {
		Model model = new LockConditionModel(3);
		
		for (int i = 0; i < 2; i++) {
			new Thread(model.newProducer()).start();
		}
		
		for (int i = 0; i < 5; i++) {
			new Thread(model.newConsumer()).start();
		}
	}

}
