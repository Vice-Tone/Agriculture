package com.ruoyi.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils2 {

    //根据格式把字符串转化为date
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);

        return date;
    }

    //根据Date转换为long类型
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static long getLongByStr(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        long datetime = date.getTime();
        return datetime;
    }

}
