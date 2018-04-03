import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		String medicareValidity = "201709";

		Calendar curCal = Calendar.getInstance();
		String year = String.valueOf(curCal.get(Calendar.YEAR));
		String month = String.valueOf(curCal.get(Calendar.MONTH));

		Integer realMonth = Integer.valueOf(month) + 1;

		System.out.println("原month=" + month + ", 新month=" + realMonth.toString());

		month = realMonth.toString();
		if (realMonth < 10) {
			month = "0" + month;
		}

		String curDate = year.concat(month);

		System.out.println("curDate=" + curDate + ", medicareValidity=" + medicareValidity);

		String isExpiredMedicare = "1";
		if (Integer.parseInt(curDate) < Integer.parseInt(medicareValidity)) {
			isExpiredMedicare = "0";
		}

		System.out.println("isExpiredMedicare=" + isExpiredMedicare);

		Map<String, String> maps = new HashMap<String, String>();
		System.out.println("==== " + maps.get("123"));

		short s1 = 1;
		s1 = (short)(s1 + 1);
		
		s1 += 1;
	}

}
