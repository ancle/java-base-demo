package prototype;

public class Resume implements Cloneable {
	private String name;
	private int age;
	private String birthday;
	private String sex;
	private String school;
	private String timeArea;
	private String company;
	
	public Resume(String name) {
		this.name = name;
	}
	
	public void setPersonInfo(String birthday, String sex, String school) {
		this.birthday = birthday;
		this.sex = sex;
		this.school = school;
	}
	
	public void setWorkExperience(String timeArea, String company) {
		this.timeArea = timeArea;
		this.company = company;
	}
	
	public Object clone() {
		Resume resume = null;
		
		try {
			resume = (Resume) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resume;
	}
	
	public void display() {
		System.out.println("姓名：" + this.name);
		System.out.println("生日：" + this.birthday + ", 性别：" + this.sex + ", 毕业学校：" + this.school);
	}
}
