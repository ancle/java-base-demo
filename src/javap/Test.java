package javap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer autoBoxing = 12;
		System.out.println("AutoBoxing : " + autoBoxing.toString());
		
		int autoUnboxing = autoBoxing;
		System.out.println("AutoUnboxing : " + autoUnboxing);
	}

}
