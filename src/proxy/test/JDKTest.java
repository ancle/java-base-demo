package proxy.test;

import proxy.intf.Master;
import proxy.intf.Person;
import proxy.jdk.HomeLink;

public class JDKTest {

	public static void main(String[] args) {
		Person person = (Person)new HomeLink(new Master()).getInstance();
		person.searchHourse();
	}

}
