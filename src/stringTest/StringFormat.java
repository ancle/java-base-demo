package stringTest;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;

public class StringFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 3.1415926;
		System.out.println("String.format() :" + String.format("%.2f", d));
		
		double d2 = 110.546;
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("DecimalFormat() : " + df.format(d2));

		double d3 = 231.45;
		BigDecimal bd = new BigDecimal(d3);
		//System.out.println("BigDecimal.setScale() : " + bd.setScale(2, BigDecimal.ROUND_HALF_DOWN));
	
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("------ BigDecimal = " + bd);
	}

}
