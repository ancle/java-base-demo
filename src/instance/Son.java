package instance;

public class Son extends Parent {
	static {
		System.out.println("----son----");
	}
	
	private long id;
	
	Son() {
		super();
	}

	Son(String name, long id) {
		super(name);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
