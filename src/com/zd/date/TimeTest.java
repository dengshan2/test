package com.zd.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by root on 11/27/15.
 * author: zd
 */
public class TimeTest {
    /**
     * main method
     * @param args 程序传入的参数
     */
    public static void main(String[] args) throws ParseException {
        TimeTest tt = new TimeTest();
        System.out.println("获取当前日期 ：" + tt.getNowTime("yyyy-MM-dd"));
        System.out.println("获取本周周一日期：" + tt.getMondayOfWeek());
        System.out.println("获取本周周天日期：" + tt.getSundayOfWeek());
        System.out.println("获取相应周的周六日期：" + tt.getSaturdayOfWeek("yyyy-MM-dd"));
        System.out.println("获取上周周一日期：" + tt.getMondayOfLastWeek());
        System.out.println("获取上周周天日期：" + tt.getSundayOfLastWeek());
        System.out.println("获取下周周一日期：" + tt.getMondayOfNextWeek());
        System.out.println("获取下周周天日期：" + tt.getSundayOfNextWeek());
        System.out.println("获取本月第一天日期：" + tt.getFirstDayOfCurrentMonth());
        System.out.println("获取本月最后一天日期：" + tt.getLastDayOfCurrentMonth());
        System.out.println("获取上月第一天日期：" + tt.getFirstDayOfLastMonth());
        System.out.println("获取上月最后一天日期：" + tt.getLastDayOfLastMonth());
        System.out.println("获取下月第一天日期：" + tt.getFirstDayOfNextMonth());
        System.out.println("获取下月最后一天日期：" + tt.getLastDayOfNextMonth());
        System.out.println("获取本年第一天日期：" + tt.getFirstDayOfCurrentYear());
        System.out.println("获取本年最后一天日期：" + tt.getLastDayOfCurrentYear());
        System.out.println("获取去年最后一天日期：" + tt.getFirstDayOfLastYear());
        System.out.println("获取去年最后一天日期：" + tt.getLastDayOfLastYear());
        System.out.println("获取明年第一天日期：" + tt.getFirstDayOfNextYear());
        System.out.println("获取明年最后一天日期：" + tt.getLastDayOfNextYear());
        System.out.println("获取本季度第一天日期：" + tt.getFirstDayOfCurrentSeason());
        System.out.println("获取本季度最后一天日期：" + tt.getLastDayOfCurrentSeason());
        System.out.println("获取本季度天数：" + tt.getDaysOfSeason());
        System.out.println("获取两个日期间隔天数：" + tt.getDaysBetweenDates("2007-9-20", "2006-9-20"));

    }

    // 获取两个日期间隔天数
    public long getDaysBetweenDates(String time1, String time2) {
        if (time1 == null || time1.equals("")) {
            return -1;
        }
        if (time2 == null || time2.equals("")) {
            return -1;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = format.parse(time1);
            date2 = format.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        return Math.abs(date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24);

    }

    // 获取本季度天数
    public long getDaysOfSeason() {
        Calendar calendar = Calendar.getInstance();
        Date date = getFirstDayOfSeason();
        calendar.setTime(date);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, 1);
        days += calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, 1);
        days += calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    // 获取本季度最后一天日期
    public Date getLastDayOfCurrentSeason() {
        Date date = getFirstDayOfSeason();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 2);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    // 获取本季度第一天日期
    public Date getFirstDayOfCurrentSeason() {
        return getFirstDayOfSeason();
    }

    // 获取当前季度第一天日期
    private Date getFirstDayOfSeason() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int season;
        if (month >= 1 && month <= 3) {
            season = 1;
        } else if (month >= 4 && month <= 6) {
            season = 2;
        } else if ((month >= 7 && month <= 9)) {
            season = 3;
        } else {
            season = 4;
        }
        calendar.set(Calendar.MONTH, array[season-1][0] - 1);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    // 获取明年最后一天日期
    public Date getLastDayOfNextYear() {
        Date date = getFirstDayOfNextYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.roll(Calendar.DAY_OF_YEAR, false);
        return calendar.getTime();
    }

    // 获取明年第一天日期
    public Date getFirstDayOfNextYear() {
        Date date = getFirstDayOfYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    // 获取去年最后一天日期
    public Date getLastDayOfLastYear() {
        Date date = getFirstDayOfYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    // 获取去年第一天日期
    public Date getFirstDayOfLastYear() {
        Date date = getFirstDayOfYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    // 获取本年最后一天日期
    public Date getLastDayOfCurrentYear() {
        Date date = getFirstDayOfYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    // 获取本年第一天日期
    public Date getFirstDayOfCurrentYear() {
        return getFirstDayOfYear();
    }

    // 获取当前年第一天日期
    private Date getFirstDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    // 获取下月最后一天的日期
    public Date getLastDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfNextMonth());
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    // 获取下月第一天的日期
    public Date getFirstDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfMonth());
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    // 获取上月最后一天的日期
    public Date getLastDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfLastMonth());
        calendar.roll(Calendar.DATE, false);
        return calendar.getTime();
    }

    // 获取上月第一天日期
    public Date getFirstDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfMonth());
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    // 获取本月最后一天日期
    public Date getLastDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfMonth());
        calendar.roll(Calendar.DATE, false);
        return calendar.getTime();
    }

    // 获取本月第一天日期
    public Date getFirstDayOfCurrentMonth() {
        return getFirstDayOfMonth();
    }

    // 获取本月第一天日期
    private Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    // 获得相应周周六的日期
    public String getSaturdayOfWeek(String timeRegex) {
        int today = getSundayPlus() - 1;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, today);
        Date date = gc.getTime();
        SimpleDateFormat format = new SimpleDateFormat(timeRegex);
        return format.format(date);
    }

    // 获取下周周天日期
    public Date getSundayOfNextWeek() {
        week = 1;
        int monday = getSundayPlus() + week * 7;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, monday);
        return gc.getTime();
    }

    // 获取下周周一日期
    public Date getMondayOfNextWeek() {
        week = 1;
        int monday = getMondayPlus() + week * 7;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, monday);
        return gc.getTime();
    }

    // 获取上周周天日期
    public Date getSundayOfLastWeek() {
        week = -1;
        int monday = getSundayPlus() + week * 7;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, monday);
        return gc.getTime();
    }

    // 获取上周周一日期
    public Date getMondayOfLastWeek() throws ParseException {
        week = -1;
        int monday = getMondayPlus() + week * 7;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, monday);
        return gc.getTime();
    }

    // 获取本周周天的日期
    public Date getSundayOfWeek() {
        week = 0;
        int sundayPlus = getSundayPlus();
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, sundayPlus);
        return gc.getTime();
    }

    // 获取当前星期与周天相差天数
    private int getSundayPlus() {
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK);
        if (1 == today) {
            return 0;
        } else {
            return 8 - today;
        }
    }

    // 获取本周一的日期
    public Date getMondayOfWeek() {
        week = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.DATE, mondayPlus);
        return gc.getTime();
    }

    // 获取当前天与周一相差天数
    private int getMondayPlus() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // 获取当天的日期， 以传入参数的格式返回时间字符串
    private String getNowTime(String timeRegex) {
        SimpleDateFormat format = new SimpleDateFormat(timeRegex);
        return format.format(new Date());
    }

    private int week;
}
