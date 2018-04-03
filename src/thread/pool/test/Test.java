package thread.pool.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import thread.pool.RunableTask;

public class Test {

	public static void main(String[] args) {
		BlockingQueue queue = new LinkedBlockingQueue<Runnable>(5);
		
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
		
		for (int i=0; i < 15; i++) {
			
			threadPool.execute(new Thread(new RunableTask(), "Thread-" + i + "'"));
			
			System.out.println("线程池中活跃的线程数：" + threadPool.getPoolSize());
			
			if (queue.size() > 0) {
				System.out.println("待办任务书：" + queue.size());
			}
		}
		
		
		threadPool.shutdown();
		
		Executor executor = Executors.newFixedThreadPool(10);
	}

}
