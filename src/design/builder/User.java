package design.builder;

public class User {
	private final String firstName;
	private final String lastName;
	
	private final int age;
	private final String phone;
	private final String address;
	
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public String toString() {
		return "username : " + this.firstName + this.lastName 
				+ ", age: " + this.age 
				+ ", phone: " + this.phone
				+ ", address: " + this.address;
	}
	
	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone = "";
		private String address = "";
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			
			return this;
		}
		
		public UserBuilder phone(String phone) {
			this.phone = phone;
			
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
}
