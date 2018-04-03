package thread.join;

public class Viewer implements Runnable {

	private Runner runner;
	
	public Viewer(Runner runner) {
		this.runner = runner;
	}
	@Override
	public void run() {
		if (null == this.runner) {
			System.out.println("对不起，无赛事。。。");
		}
		
		System.out.println("观众静待比赛开始");
		Thread t1 = new Thread(this.runner, "110米跨栏");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("观众准备散场。。。");
	}

}
