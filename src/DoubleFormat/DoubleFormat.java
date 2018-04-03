package DoubleFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DoubleFormat {
	public static void main(String[] args) {
		Double d = 0.0d;
		
		BigDecimal bigD = new BigDecimal(d);
		BigDecimal bigA = new BigDecimal(0d);
		
		int result = bigD.compareTo(bigA);
		if (result == 0) {
			System.out.println(String.valueOf(d));
		} else {
			DecimalFormat df = new DecimalFormat("#.0");
			System.out.println(df.format(d));
		}
		
		
	}
}
