package pAndc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import pAndc.common.Model;
import pAndc.common.Task;
import pAndc.consumer.AbstractConsumer;
import pAndc.producer.AbstractProducer;

public class WaitNofityModel implements Model {
	private final Object BUFFER_LOCK = new Object();
	private final Queue<Task> queue = new LinkedList<Task>();
	private final AtomicInteger increTaskNo = new AtomicInteger(0);
	private int cap = 0;
	
	public WaitNofityModel(int cap) {
		this.cap = cap;
	}

	@Override
	public Runnable newConsumer() {
		return new ConsumerImpl();
	}

	@Override
	public Runnable newProducer() {
		return new ProducerImpl();
	}

	private class ConsumerImpl extends AbstractConsumer {

		@Override
		public void consume() throws InterruptedException {
			synchronized(BUFFER_LOCK) {
				while (queue.size() == 0) {
					BUFFER_LOCK.wait();
				}
				
				Task task = queue.poll();
				assert task != null;
				
				Thread.sleep((long) (500 + Math.random() * 500));
				System.out.println("consume : " + task.getNo());
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	private class ProducerImpl extends AbstractProducer {
		@Override
		public void produce() throws InterruptedException {
			Thread.sleep((long) (Math.random() * 1000));
			synchronized (BUFFER_LOCK) {
				while (queue.size() == cap) {
					BUFFER_LOCK.wait();
				}
				
				Task task = new Task(increTaskNo.getAndIncrement());
				queue.offer(task);
				System.out.println("produce : " + task.getNo());
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Model model = new WaitNofityModel(10);
		
		for (int i = 0; i < 2; i++) {
			new Thread(model.newConsumer()).start();
		}
		
		for (int i = 0; i < 5; i++) {
			new Thread(model.newProducer()).start();
		}
	} 
}
