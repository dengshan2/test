package com.zd.date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by root on 11/27/15.
 * author: zd
 */
public class CalendarTest {
    public static void main(String[] args) {
        System.out.println(getMondayOfWeek());
    }

    public static String getMondayOfWeek() {
        int mondayPuls = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPuls);
        Date monday = currentDate.getTime();
        DateFormat format = DateFormat.getDateInstance();
        return format.format(monday);
    }

    private static int getMondayPlus() {
        Calendar calendar1 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }
}
