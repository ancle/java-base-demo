package thread.pandc.model.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import thread.pandc.consumer.AbstractConsumer;
import thread.pandc.model.Model;
import thread.pandc.producer.AbstractProducer;
import thread.pandc.task.Task;

public class LockConditionModel2 implements Model {
	
	private AtomicInteger taskNo = new AtomicInteger(0);
	private Queue<Task> buffer = new LinkedList<Task>();
	private final int cap;
	private final Lock CONSUMER_LOCK = new ReentrantLock();
	private final Lock PROCUDER_LOCK = new ReentrantLock();
	private final Condition NOT_EMPTY = CONSUMER_LOCK.newCondition();
	private final Condition NOT_FULL = PROCUDER_LOCK.newCondition();
	
	public LockConditionModel2(int cap) {
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
			CONSUMER_LOCK.lockInterruptibly();
			
			try {
				while (buffer.size() == 0) {
					NOT_EMPTY.await();
				}
				
				Task task = buffer.poll();
				
				Thread.sleep((long)Math.random() * 1000);
				System.out.println("consumer task : " + task.getTaskNo());
				
				NOT_EMPTY.signalAll();
				
			} finally {
				CONSUMER_LOCK.unlock();
			}
		}
		
	}
	
	private class ProducerImpl extends AbstractProducer {

		@Override
		public void produce() throws InterruptedException {
			
		}
		
	}
}
