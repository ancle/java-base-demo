package classloader;

public class Parent {
	static {
		System.out.println("Parent init.");
	}
	
	public static final String CONST_STR = "hello world.";
	
	public static int COUNT = 100;
	
	protected String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
