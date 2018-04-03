package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) throws ParseException {
		String dateStr = "2017-08-01";
		String lateStr = "2017-08-11";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar curCal = Calendar.getInstance();
		curCal.setTime(format.parse(dateStr));
		
		curCal.add(Calendar.DAY_OF_MONTH, 6);
		
		String newDate = format.format(curCal.getTime());
		
		System.out.println(newDate);
		
		Date early = format.parse(dateStr);
		Date late = format.parse(lateStr);
		
		System.out.println(daysBetween(early, late));
	}
	
	public static int daysBetween(Date early, Date late) throws ParseException {

		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		// 设置时间为0时
		calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calst.set(java.util.Calendar.MINUTE, 0);
		calst.set(java.util.Calendar.SECOND, 0);
		caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
		caled.set(java.util.Calendar.MINUTE, 0);
		caled.set(java.util.Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days + 1;
	}
}
