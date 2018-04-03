package generic.test;

public class TestMain {

	public static void main(String[] args) {
		Point<String> point = new Point<String>();
		point.setVar("abc");
		
		System.out.println("test : " + point.getVar());
	}

}
