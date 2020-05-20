package com.bins.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author leo-bin
 * @date 2020/5/20 16:09
 * @apiNote 封装一些关于时间的方法
 */
public class DateUtil {

    /**
     * 日期格式：2020-05-20 16:21:42
     */
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 获取现在的日期,返回字符串
     */
    public static String getCurDateString() {
        Date currentDate = new Date();
        String dateStr = FORMAT.format(currentDate);
        return dateStr;
    }


    /**
     * 字符串日期转Date
     */
    public static Date str2Date(String dateStr) {
        Date date = null;
        try {
            date = FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取具体日期中的年份
     */
    public static int getYearOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 获取具体日期中的月份（阳历）
     */
    public static int getMonthOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 获取具体日期中属于月份中的哪一天
     */
    public static int getDayOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 获取具体日期中的小时
     */
    public static int getMinuteOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * 获取具体日期中的小时
     */
    public static int getSecondOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }


    /**
     * 获取具体日期中的小时
     */
    public static int getHourOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    public static void main(String[] args) {
        String currentDateStr = getCurDateString();
        System.out.println("现在的时间是：" + currentDateStr);
        Date currentDate = str2Date(currentDateStr);


        /*String dateStr = "2020-02-01 12:00:00";*/
        /*String dateStr="2020-02-01 12:01:00";*/
        /*String dateStr="2020-02-01 00:00:00";*/
        String dateStr = "2020-02-01 00:00:01";

        Date date = str2Date(dateStr);

        int year = getYearOfDate(date);
        int month = getMonthOfDate(date);
        int day = getDayOfDate(date);
        int hour = getHourOfDate(date);
        int minute = getMinuteOfDate(date);
        int second = getSecondOfDate(date);
        System.out.println("日期是" + dateStr);
        System.out.println("年份是：" + year);
        System.out.println("月份是：" + month);
        System.out.println("第几天：" + day);
        System.out.println("日期中的小时：" + hour);
        System.out.println("日期中的分钟：" + minute);
        System.out.println("日期中的秒：" + second);
    }

}

