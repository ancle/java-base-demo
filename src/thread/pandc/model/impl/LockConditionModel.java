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

public class LockConditionModel implements Model {
	private Queue<Task> buffer = new LinkedList<Task>();
	private AtomicInteger taskNo = new AtomicInteger(0);
	private final Lock BUFFER_LOCK = new ReentrantLock();
	private final Condition bufferCondition = BUFFER_LOCK.newCondition();
	private final int cap;
	
	public LockConditionModel(int cap) {
		this.cap = cap;
	}

	@Override
	public Runnable newConsumer() {
		// TODO Auto-generated method stub
		return new ConsumerImpl();
	}

	@Override
	public Runnable newProducer() {
		// TODO Auto-generated method stub
		return new ProducerImpl();
	}
	
	private class ConsumerImpl extends AbstractConsumer {

		@Override
		public void consume() throws InterruptedException {
			BUFFER_LOCK.lockInterruptibly();
			
			try {
				while (buffer.size() == 0) {
					bufferCondition.await();
				}
				
				Task task = buffer.poll();
				
				assert task != null;
				
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("consumer task:" + task.getTaskNo());
				
				bufferCondition.signalAll();
			} catch(InterruptedException  e) {
				e.printStackTrace();
			} finally {
				BUFFER_LOCK.unlock();
			}
		}
	}
	
	private class ProducerImpl extends AbstractProducer {

		@Override
		public void produce() throws InterruptedException {
			BUFFER_LOCK.lockInterruptibly();
			
			try {
				while (buffer.size() == cap) {
					bufferCondition.await();
				}
				
				Task newTask = new Task(taskNo.getAndIncrement());
				System.out.println("producer task : " + newTask.getTaskNo());
				buffer.offer(newTask);
				
				bufferCondition.signalAll();
			} finally {
				BUFFER_LOCK.unlock();
			}
		}
		
	}

}
