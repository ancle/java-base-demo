package generic;

import java.util.Random;

public class FruitGeneratorImpl implements Generator<String> {
	private String[] fruits = {"Apple", "Banana", "Pear"};
	
	public String next() {
		return fruits[(new Random()).nextInt(3)];
	}
}
