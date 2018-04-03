package prototype.test;

import prototype.Resume;

public class Client {

	public static void main(String[] args) {
		Resume  a = new Resume("小李子");
		a.setPersonInfo("1987-01-06", "男", "太原理工大学");
		a.setWorkExperience("033006", "山西智杰软件科技");
		
		a.display();
		
		System.out.println(" -------------- ");
		Resume b = (Resume) a.clone();
		
		b.display();
		
		System.out.print(" a == b? ");
		System.out.println(a == b);
		
		System.out.print(" a.equals(b)? ");
		System.out.println(a.equals(b));
		
		System.out.print(" a.getClass() == b.getClass()? ");
		System.out.println(a.getClass() == b.getClass());
	}

}
