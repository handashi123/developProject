package com.handashi.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String amt = "50940";
		int intAmt = Integer.parseInt(amt);
		
		String strDateString = "20190304060000";
		String endDateString = "20190304090000";
		
		// 3자리마다 콤마
		System.out.println(String.format("%,d", intAmt));
		
		// String을 date형식으로 변경
		Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateString);
		System.out.println(date);
		
		// 원하는 형식으로 변경
		String dateFormatString = new SimpleDateFormat("YYYY/MM/dd(E) HH:mm").format(date);
		
		dateFormatString = dateFormatString + " - " + new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("yyyyMMddHHmmss").parse(endDateString));
		
		System.out.println(dateFormatString);
		
	}

}
