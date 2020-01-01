package com.handashi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 기준 월요일 날짜 : " + getCurMonday());
		
		System.out.println("현재 기준 일요일 날짜 : " + getCurSunday());
		
		System.out.println("현재 날짜 기준 주차 : " + getWeek());
		
		System.out.println("설정한 날의 해당월의 마지막날짜 : " + lastDayOfMonth("20190924"));
		
		
		
		String dateTime = "";

		Calendar cal = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

		try {
			String today = ""; // 오늘
			Date targetDay = null; // Biz 로그 대상일(하루 전일자)
			today = sdf.format(d);
			targetDay = sdf.parse(today);
			cal.setTime(targetDay);
			cal.add(Calendar.DAY_OF_MONTH, -2);
			dateTime = sdf.format(cal.getTime());
		} catch (ParseException pe) {
			System.out.println(pe);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(dateTime);
		
	}
	
	/**
	 * 현재 날짜 기준 월요일
	 * @return
	 */
	public static String getCurMonday() {
		SimpleDateFormat format = new SimpleDateFormat("yyy.MM.dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return format.format(c.getTime());
	}
	/**
	 * 현재 날짜 기준 일요일
	 * @return
	 */
	public static String getCurSunday() {
		SimpleDateFormat format = new SimpleDateFormat("yyy.MM.dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		c.add(c.DATE, 7);
		return format.format(c.getTime());
	}
	/**
	 * 현재 날짜 기준 주차
	 * @return
	 */
	public static String getWeek() {
		Calendar c = Calendar.getInstance();
		String week = String.valueOf(c.get(Calendar.WEEK_OF_MONTH));
		return week;
	}
	
	public static String lastDayOfMonth(String yyyymmdd) {
		
		int year = Integer.parseInt(yyyymmdd.substring(0, 4));
		int month = Integer.parseInt(yyyymmdd.substring(4, 6));
		int day = Integer.parseInt(yyyymmdd.substring(6, 8));
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		
		cal.set(year, month - 1, day);
		
//		System.out.println( cal.getActualMaximum(Calendar.DAY_OF_MONTH) );
		
		return yyyymmdd.substring(0, 6) + String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
}
