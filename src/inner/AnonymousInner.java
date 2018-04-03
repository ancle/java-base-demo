package inner;

class Animal {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int fly() {
		return 0;
	};
}

public class AnonymousInner {
	
	public void fly(Animal animal) {
		System.out.println(animal.getName() + "能够飞" + animal.fly() + "米");
	}

	public static void main(String[] args) {
		AnonymousInner inner = new AnonymousInner();
		inner.fly(new Animal() {
			public String getName() {
				return "百灵鸟";
			}

			@Override
			public int fly() {
				return 10000;
			}
			
		});
	}

}
