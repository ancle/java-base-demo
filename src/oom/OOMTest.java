package oom;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {

	public static void main(String[] args) {
		List<OOMTest> lists = new ArrayList<OOMTest>();
		
		while(true) {
			lists.add(new OOMTest());
		}
	}

}
