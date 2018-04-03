package thread;

public class WaitTest {
	
	static class WaitThread extends Thread {
		public WaitThread(String threadName) {
			super(threadName);
		}
		
		public void run() {
			synchronized(this) {
				System.out.println("当前线程(" + Thread.currentThread().getName() + ")要执行notfiy()方法");
				
				//notify();
				
				while(true)
		            ;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WaitThread waitThread  = new WaitThread("wait");
		
		synchronized(waitThread) {
			System.out.println(Thread.currentThread().getName() + " will start the thread : " + waitThread.getName());
			waitThread.start();
			
			System.out.println(Thread.currentThread().getName() + " will wait.");
			waitThread.wait(5000);
			
			System.out.println(Thread.currentThread().getName() + " continue.");
			System.out.println("");
		}
	}

}
