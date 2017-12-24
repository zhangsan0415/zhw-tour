package com.zhw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
	
	public static String formatCurrentDate() {
		return formatDate(new Date());
	}
	
	public static String formatDate(Date date) {
		return sf.format(date);
	}
	
	
}
