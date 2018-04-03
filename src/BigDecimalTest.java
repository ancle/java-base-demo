import java.math.BigDecimal;
import java.text.DecimalFormat;


public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal heaveLine = new BigDecimal(200);
		BigDecimal thisUnenableFee = new BigDecimal(350);
		BigDecimal personalFee = new BigDecimal(460); // 个人自付费用
		BigDecimal baseline = personalFee.subtract(heaveLine).subtract(thisUnenableFee);
		BigDecimal financialSubsidy = baseline;
		
		String hosCode = "112";
		
		if ("112".equals(hosCode)) {
			financialSubsidy = baseline.multiply(new BigDecimal("0.9"));
		} 
		
		if (financialSubsidy.compareTo(BigDecimal.ZERO) <= 0) {
			financialSubsidy = BigDecimal.ZERO;
		}
		
		
		Double medicarePayFee = 229.16;
		Double mzjzFee = 229.16;
		
		Double selfPayFee = medicarePayFee - mzjzFee;
		
		
		
		selfPayFee = selfPayFee - 0.0;
		
		String test="0.00";
		
		int result = new BigDecimal(test).compareTo(BigDecimal.ZERO);
		
		Double ration = 75.19;
		
		Double fixedRation = 80.0;
		
		double resultD = ration - fixedRation;
		
		if (resultD <= 5 && resultD >= -5) {
			ration = 75.0;
		}
		
		
		System.out.println(ration);
		
		double t = 321.03d;
		
		DecimalFormat df =  new DecimalFormat("#0.0");
		
		System.out.println(df.format(t));
	}

}
