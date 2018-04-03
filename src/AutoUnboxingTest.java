
public class AutoUnboxingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(2);
		Integer b = 2;
		Integer d = 2;
		int c = 2;
		
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(b == d);
		
		Integer f1 = 150;
		Integer f2 = 150;
		
		System.out.println(f1 == f2);
		System.out.println(f1);
	}

}
