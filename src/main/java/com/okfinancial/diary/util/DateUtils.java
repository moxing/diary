package com.okfinancial.diary.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	static Calendar cal = Calendar.getInstance();
	static {
		cal.setFirstDayOfWeek(Calendar.MONDAY);
	}
	
	/**
	 * 获取传入时间的周一
	 * 
	 * @param date 当前时间
	 * @return 返回传入时间当周星期一
	 */
	public static Date getNowWeekMonday(Date date) {
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	/**
	 * 获取传入时间的上周一
	 * 
	 * @param date 当前时间
	 * @return 返回上周一时间
	 */
	public static Date getLastWeekMonday(Date date) {
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		 
		return cal.getTime();
	}
	
	/**
	 * 获取传入时间下周一
	 * @param date 当前时间
	 * @return 返回下周一日期
	 */
	public static Date getNextWeekMonday(Date date) {
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		 
		return cal.getTime();
	}
	
	/**
	 * 查询当周周日
	 * @param date 当前时间 
	 * @return 当周周日
	 */
	public static Date getNowWeekSunday(Date date) {
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, 1);
		 
		return cal.getTime();
	}
	
	
	/**
	 * 查询下周周日
	 * @param date 当前时间
	 * @return 返回下周周日
	 */
	public static Date getNextWeekSunday(Date date) {
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		 
		return cal.getTime();
	}
	
	/**
	 * 查询上周周日
	 * @param date 当前时间
	 * @return 返回上周周日
	 */
	public static Date getLastWeekSunday(Date date) {
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		 
		return cal.getTime();
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(DateUtils.getNextWeekSunday(date));
		System.out.println(DateUtils.getNextWeekMonday(date));
		System.out.println(DateUtils.getNowWeekSunday(date));
		System.out.println(DateUtils.getNowWeekMonday(date));
		System.out.println(DateUtils.getLastWeekSunday(date));
		System.out.println(DateUtils.getLastWeekMonday(date));
	}
}
