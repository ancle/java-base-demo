package generic;

public class Generic<T> {
	private T key;
	
	public Generic(T key) {
		this.key = key;
	}
	
	public T getKey() {
		return this.key;
	}
	
	public <T> T getTKey() {
		return (T) this.key;
	}
	
	public void test(Generic<? extends Number> obj) {
		
	}
	
	public static void main(String[] args) {
		Generic<String> generic = new Generic<String>("bac");
		
		System.out.println(generic.getKey());
	}
}
