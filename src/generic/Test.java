package generic;

public class Test {

	public static void main(String[] args) {
		Generic<Number> number = new Generic<Number>(456);
		Generic<Integer> integer = new Generic<Integer>(123);
		
		//showKeyValue1(number);
		//showKeyValue1(integer);
		
		showKeyValue2(number);
		showKeyValue2(integer);
	}

	private static void showKeyValue1(Generic<Number> obj) {
		System.out.println(obj.getKey());
	}
	
	private static void showKeyValue2(Generic<?> obj) {
		System.out.println(obj.getKey());
	}
}
