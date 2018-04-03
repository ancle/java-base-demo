package reference;

public class TestClass {

	public static void main(String[] args) {
		Father f = new Son();
		Son s = (Son)f;
		System.out.println("s hashcode:" + s.hashCode() + " | f hashcode :" + f.hashCode());
		System.out.println("s == f : " + (s == f));
	}

}
