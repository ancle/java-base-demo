package thread.pandc.model.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import thread.pandc.consumer.AbstractConsumer;
import thread.pandc.model.Model;
import thread.pandc.producer.AbstractProducer;
import thread.pandc.task.Task;

public class BlockingQueueModel implements Model {
	private AtomicInteger taskNo = new AtomicInteger(0);
	private BlockingQueue<Task> bufferQueue;
	
	public BlockingQueueModel(int cap) {
		bufferQueue = new LinkedBlockingQueue<Task>(cap);
	}
	
	public BlockingQueueModel() {
		this(10);
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
			Task task = bufferQueue.take();
			
			Thread.sleep((long)Math.random() * 1000);
			
			System.out.println("consumer : " + task.getTaskNo());
		}
	}
	
	private class ProducerImpl extends AbstractProducer {
		@Override
		public void produce() throws InterruptedException {
			Thread.sleep((long)Math.random() * 100);
			Task newTask = new Task(taskNo.getAndIncrement());
			bufferQueue.put(newTask);
			
			System.out.println("producer : " + newTask.getTaskNo());
		}
		
	}

}
