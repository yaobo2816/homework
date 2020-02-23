package com.neo.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Until {
    public static Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(strDate);
        return date;
    }
    public static String append(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        result.append(str1);
        result.append(str2);
        return result.toString();
    }

    public static String formatDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE hh:mm a");
        String dateStr = sdf.format(strToDate(strDate));
        return dateStr;
    }

    public static String changeHour(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar rightNow = Calendar.getInstance();
        Date resultDate = strToDate(date);
        rightNow.setTime(resultDate);
        rightNow.add(Calendar.HOUR, -3);
        Date dt1 = rightNow.getTime();
        String strDate = sdf.format(dt1);
        return strDate;
    }

    public static String DateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
