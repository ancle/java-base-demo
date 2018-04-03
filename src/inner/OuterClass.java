package inner;

public class OuterClass {
	private String str;
	
	public void outerDisplay() {
		System.out.println("outerClass...");
	}
	
	private class InnerClass {
		public void innerDisplay() {
			str = "innerClass...";
			System.out.println(str);
			outerDisplay();
		}
	}
	
	public InnerClass getInnerClass() {
		return new InnerClass();
	}

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.getInnerClass();
		innerClass.innerDisplay();
	}

}
