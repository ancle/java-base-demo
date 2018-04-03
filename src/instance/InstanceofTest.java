package instance;

public class InstanceofTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son son = new Son("ancle", 123456L);
		
		if (son.getClass().equals(Parent.class)) {
			System.out.println("getClass equals : true");
		} else {
			System.out.println("getClass equals ：false");
		}
		
		if (son instanceof Parent) {
			System.out.println("Object equals ： true");
		} else {
			System.out.println("Object equals ：false");
		}
	}

}
