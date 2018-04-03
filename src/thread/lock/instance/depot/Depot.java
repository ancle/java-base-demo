package thread.lock.instance.depot;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {
	private Lock lock = null;
	private Condition fullCondition = null;
	private Condition emptyCondition = null;
	
	private AtomicInteger capacity;
	private AtomicInteger size;
	
	public Depot(int capacity) {
		lock = new ReentrantLock();
		fullCondition = lock.newCondition();
		emptyCondition = lock.newCondition();
		
		this.capacity = new AtomicInteger(capacity);
		size = new AtomicInteger();
	}
	
	public void produce(int value) {
		lock.lock();
		int left = value;
		int total = this.capacity.get();
		try {
			while (value > 0) {
				// 判断当前仓库是否满仓
				// 如果满仓的情况下，让生产者停工待产
				while (this.size.get() == total) {
					fullCondition.await();
				}
				
				int sizeVal = this.size.get();
				int inc = (left <= (total - sizeVal)? left : (total - sizeVal));
				this.size.set(sizeVal + inc);
				left -= inc;
				
				System.out.println("%s produce(");
				//通知消费者进行消费
				emptyCondition.signal();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void consume(int value) {
		lock.lock();
		
		int left = value;
		
		try {
			while (this.size.get() <= 0) {
				fullCondition.await();
			}
			
			int sizeVal = this.size.get();
			int dec = ((sizeVal - left > 0)? left : sizeVal);
			
			sizeVal -= dec;
			left -= dec;
			
			this.size.set(sizeVal);
			
			emptyCondition.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
}
