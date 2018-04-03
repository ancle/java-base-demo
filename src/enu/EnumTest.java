package enu;

public class EnumTest {

	public static void main(String[] args) {
		for (WeekEnum day : WeekEnum.values()) {
			
			System.out.println("name : " + day.name() + " || ordinal : " + day.ordinal() + " || desc： " + day.getDesc());
		}
		
	}

}
