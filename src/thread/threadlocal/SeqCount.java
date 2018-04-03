package thread.threadlocal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeqCount {
	
	private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};
	
	public int nextSeq() {
		seqCount.set(seqCount.get() + 1);
		
		return seqCount.get();
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();
		
		SeqCount seqCount = new SeqCount();
		
		SeqThread t1 = new SeqThread(seqCount);
		SeqThread t2 = new SeqThread(seqCount);
		SeqThread t3 = new SeqThread(seqCount);
		
		new Thread(t1, "t1").start();
		
		new Thread(t2, "t2").start();
		
		new Thread(t3, "t3").start();
	}
	
	private static class SeqThread implements Runnable {
		private SeqCount seqCount = null;
		SeqThread(SeqCount seqCount) {
			this.seqCount = seqCount;
		}
		
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " : seqCount = " + this.seqCount.nextSeq());
			}
		}
	}
}
