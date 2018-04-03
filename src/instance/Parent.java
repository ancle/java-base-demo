package instance;

public class Parent {
	static {
		System.out.println("---parent---");
	}
	
	private String name;
	
	Parent() {
		
	}
	
	Parent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
