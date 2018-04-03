package thread.join;

public class Runner implements Runnable {

	private String name;
	
	public Runner(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(this.name + "比赛开始...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(this.name + "比赛结束...");
	}

}
