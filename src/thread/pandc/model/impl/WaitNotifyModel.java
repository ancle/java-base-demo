package thread.pandc.model.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import thread.pandc.consumer.AbstractConsumer;
import thread.pandc.model.Model;
import thread.pandc.producer.AbstractProducer;
import thread.pandc.task.Task;

public class WaitNotifyModel implements Model {
	private final int cap;
	private AtomicInteger taskNo = new AtomicInteger(0);
	private Queue<Task> buffer = new LinkedList<Task>();
	private final Object BUFFER_LOCK = new Object();
	
	public WaitNotifyModel(int cap) {
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
			Task task = null;
			synchronized (BUFFER_LOCK) {
				while (buffer.size() == 0) {
					BUFFER_LOCK.wait();
				}
				
				task = buffer.poll();
				
				assert task != null;
				
				Thread.sleep((long)Math.random() * 1000);
				
				System.out.println("consumer:" + task.getTaskNo());
				
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	private class ProducerImpl extends AbstractProducer {

		@Override
		public void produce() throws InterruptedException {
			synchronized (BUFFER_LOCK) {
				while (buffer.size() == cap) {
					BUFFER_LOCK.wait();
				}
				
				Task newTask = new Task(taskNo.getAndIncrement());
				
				Thread.sleep((long) Math.random() * 5000);
				
				buffer.offer(newTask);
				System.out.println("producer:" + newTask.getTaskNo());
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}

}
