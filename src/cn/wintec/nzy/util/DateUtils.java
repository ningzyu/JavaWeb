package cn.wintec.nzy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getCurrentTime(String pattern) {
		String datetime = "";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		datetime = df.format(new Date());

		return datetime;
	}

	public static java.sql.Date strToDate(String strDate, String pattern) {
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		java.util.Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		return date;
	}

}
