package stringTest;

public class EqualsTest {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.println("str1 == str2 : " + str1 == str2);
		System.out.println("str1 == str3 : " + str1 == str3);
		System.out.println("str1.equals(str2): " + str1.equals(str2));
		System.out.println("str3.equals(str4): " + str3.equals(str4));
		
		System.out.println("str1 hashCode = " + str1.hashCode());
		System.out.println("str2 hashCode = " + str2.hashCode());
		System.out.println("str3 hashCode = " + str3.hashCode());
		System.out.println("str4 hashCode = " + str4.hashCode());
		
		char val[] = str1.toCharArray();

		int h = 0;
        for (int i = 0; i < val.length; i++) {
            h = 31 * h + val[i];
            System.out.println(" h = " + 31 * h + ", val=" + val[i]);
            System.out.println(" h = " + h);
        }
        
        System.out.println(" h = " + h);
	}

}
