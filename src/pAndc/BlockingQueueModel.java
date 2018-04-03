package pAndc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import pAndc.common.Model;
import pAndc.common.Task;
import pAndc.consumer.AbstractConsumer;
import pAndc.producer.AbstractProducer;

public class BlockingQueueModel implements Model {
	private final BlockingQueue<Task> queue;
	private final AtomicInteger increTaskNo = new AtomicInteger(0);
	
	public BlockingQueueModel(int cap) {
		queue = new LinkedBlockingQueue<Task>(cap);
	}

	@Override
	public Runnable newConsumer(){
		return new ConsumerImpl();
	}

	@Override
	public Runnable newProducer() {
		return new ProducerImpl();
	}

	private class ConsumerImpl extends AbstractConsumer {
		@Override
		public void consume() throws InterruptedException {
			Task task = queue.take();
			Thread.sleep((long) (500 + Math.random() * 500));
			System.out.println("consume : " + task.getNo());
		}
	}
	
	private class ProducerImpl extends AbstractProducer {
		@Override
		public void produce() throws InterruptedException {
			Thread.sleep((long) (Math.random() * 1000));
			Task task = new Task(increTaskNo.getAndIncrement());
			queue.put(task);
			System.out.println("produce : " + task.getNo());
		}
		
	}
	
	public static void main(String[] args) {
		Model model = new BlockingQueueModel(3);
		
		for (int i = 0; i < 2; i++) {
			new Thread(model.newConsumer()).start();
		}
		
		for (int i = 0; i < 5; i++) {
			new Thread(model.newProducer()).start();
		}
	}
}
