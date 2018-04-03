package DoubleFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String idcard = "142701198701064511";
		String birthday = idcard.substring(6, 14);
		
		String time = "2017-07-01";
		String year = time.substring(0, 4);
		String month = time.substring(5, 7);
		String day = time.substring(8, 10);
		
		String orginalYear = time.substring(0, 4);
		String newYear = String.valueOf(Integer.valueOf(orginalYear) + 1);
		String orginalTime = time.substring(4, 10);
		
		Integer intDay = Integer.valueOf("01");
		System.out.println(" newDate = " + (newYear + orginalTime));
		
		/*String dayStr = time.substring(-2);
		System.out.println("dayStr = " + dayStr);*/
		
		System.out.println("year = " + year + " || month = " + month + " || day = " + day);
		
		String dateTime = "201712";
		
		System.out.println(dateTime.length());
		
		if (!"0".equals(dateTime) && dateTime.length() > 4) {
			System.out.println(dateTime.substring(0, 4) + " || " + dateTime);
		} else {
			System.out.println("error");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar curCal = Calendar.getInstance();
		curCal.setTime(new Date());
		
		curCal.set(Calendar.DAY_OF_MONTH,curCal.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为1号,当前日期既为本月第一天 
	    String lastDay = format.format(curCal.getTime());
	    System.out.println("-----2------lastDay:"+lastDay);
		
		/*
		Calendar curCal = Calendar.getInstance();
		String year = String.valueOf(curCal.get(Calendar.YEAR));
		String month = String.valueOf(curCal.get(Calendar.MONTH));
		if (month.length() == 1) {
			month = "0" + (Integer.parseInt(month) + 1);
		}
		
		String curDate = year.concat(month);
		
		System.out.println("curDate = " + Integer.parseInt(curDate)); 
		String isExpiredMedicare = "";
		if (Integer.parseInt(curDate + 1) < Integer.parseInt(dateTime)) {
			isExpiredMedicare = " zheng chang";
		} else {
			isExpiredMedicare = "guo qi";
		}
		
		System.out.println(isExpiredMedicare);*/
	}

}
