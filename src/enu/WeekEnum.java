package enu;

public enum WeekEnum {
	
	MONDAY("星期一", "MONDAY"), TUESDAY("星期二", "TUESDAY"), WEDNESDAY("星期三", "WEDNESDAY");
	
	
	
	private String name;
	private String desc;
	
	private WeekEnum(String desc, String name) {
		this.desc = desc;
		this.name = name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getName() {
		return this.name();
	}
	
}
