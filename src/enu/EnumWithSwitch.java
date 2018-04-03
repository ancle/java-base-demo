package enu;

public class EnumWithSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printName(Color.GREEN);
	}

	private static void printName(Color color) {
		switch (color) {
		case BLUE:
			System.out.println("蓝色");
			break;
		case RED:
			System.out.println("红色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		default:
		}
	}
}
