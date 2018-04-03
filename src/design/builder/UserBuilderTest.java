package design.builder;

public class UserBuilderTest {

	public static void main(String[] args) {
		User user = new User.UserBuilder("yi", "wq")
							.age(31)
							.phone("13834247579")
							.build();
		System.out.println(user.toString());
	}

}
