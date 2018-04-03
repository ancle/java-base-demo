package thread.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong(100);
		System.out.println("原值=" + atomicLong.get());
		System.out.println("decrementAndGet() = " + atomicLong.decrementAndGet());
		System.out.println("getAndIncrement() = " + atomicLong.getAndIncrement());
		System.out.println("incrementAndGet() = " + atomicLong.incrementAndGet());
		
		System.out.println("getAndAdd() = " + atomicLong.getAndAdd(10L) );
		System.out.println("addAndGet() = " + atomicLong.addAndGet(20L));
	}

}
