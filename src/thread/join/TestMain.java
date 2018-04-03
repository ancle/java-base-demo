package thread.join;

public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("current running thread name : " + Thread.currentThread().getName());
		
		Thread t1 = new Thread(new Viewer(new Runner("110米跨栏")), "观众");
		t1.start();
		
		System.out.println("finished thread : " + Thread.currentThread().getName());
	}

}
