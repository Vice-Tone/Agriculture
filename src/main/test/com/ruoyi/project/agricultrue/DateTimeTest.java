package com.ruoyi.project.agricultrue;

import com.ruoyi.common.utils.DateUtils2;
import org.junit.Test;

import java.text.ParseException;

public class DateTimeTest {

    @Test
    public void strTime2Long() {
        String strTime1 = "2019-11-01";
        String strTime2 = "2019-12-20";
        String strTime3 = "2019-05-21";
        String strTime4 = "2019-06-20";
        String strTime5 = "2019-12-22";
        try {
            System.out.println(DateUtils2.getLongByStr(strTime1, "yyyy-MM-dd"));
            System.out.println(DateUtils2.getLongByStr(strTime2, "yyyy-MM-dd"));
            System.out.println(DateUtils2.getLongByStr(strTime3, "yyyy-MM-dd"));
            System.out.println(DateUtils2.getLongByStr(strTime4, "yyyy-MM-dd"));
            System.out.println(DateUtils2.getLongByStr(strTime5, "yyyy-MM-dd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String strtim="2020-02-27";
        try {
            System.out.println("strtime "+DateUtils2.getLongByStr(strtim, "yyyy-MM-dd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
