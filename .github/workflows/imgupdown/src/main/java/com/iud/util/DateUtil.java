package com.iud.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String HH_mm_ss = "HH:mm:ss";
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss";
	
	public static String getTime(Date date){
		return getTime(date, HH_mm_ss);
	}
	public static String getTime(Date date, String timeFormat){
		if(Utility.isEmpty(date)){
			return "";
		}
		if(Utility.isEmpty(timeFormat)){
			timeFormat = HH_mm_ss;
		}
		DateFormat df = new SimpleDateFormat(timeFormat);
		return df.format(date);
	}
	
	public static String getCurrentDate(){
		return getDate(new Date(), yyyy_MM_dd_HH_mm_ss);
	}
	public static String getCurrentDate(String dateFormat){
		return getDate(new Date(), dateFormat);
	}
	
	public static String getDate(Date date){
		return getDate(date, yyyy_MM_dd_HH_mm_ss);
	}
	
	public static String getDate(Date date, String dateFormat){
		if(Utility.isEmpty(date)){
			return "";
		}
		if(Utility.isEmpty(dateFormat)){
			dateFormat = yyyy_MM_dd_HH_mm_ss;
		}
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date);
	}
	
	public static Date getDateObject(String date){
		DateFormat df = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
		Date parseDate = null;
		try {
			parseDate = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
	
}
