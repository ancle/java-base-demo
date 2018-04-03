package oom;

public class JVMStackSOF {
	
	private int stackLength = 0;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JVMStackSOF stackSof = new JVMStackSOF();
		try {
		stackSof.stackLeak();
		} catch(Exception e) {
			System.out.println("stack length : " + stackSof.stackLength);
			throw e;
		}
	}

}
