package enu;

public enum Color {
	GREEN("绿色", 0), RED("红色", 1), BLUE("蓝色", 2), YELLOW("黄色", 3);
	
	private String chineseName;
	private int index;
	
	private Color(String chineseName, int index) {
		this.chineseName = chineseName;
		this.index = index;
	}
	
	public String getChineseName() {
		return this.chineseName;
	}
	
	public int getIndex() {
		return this.index;
	}
}
