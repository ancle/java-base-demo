package thread.instance;

import thread.instance.consumer.Consumer;
import thread.instance.depot.Depot;
import thread.instance.producer.Producer;

public class ProducerAndConsumerTest {

	public static void main(String[] args) {
		Depot depot = new Depot(100);
		
		Producer producer = new Producer(depot);
		Consumer consumer = new Consumer(depot);
		
		producer.produce(50);
		producer.produce(100);
		consumer.consume(30);
		producer.produce(50);
		consumer.consume(50);
		consumer.consume(100);
	}

}
