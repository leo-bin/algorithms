package com.bins.util;

import jodd.datetime.JDateTime;
import jodd.datetime.TimeUtil;


/**
 * @author leo-bin
 * @date 2020/3/1 17:37
 * @apiNote 根据日期来计算第几周
 */
public class WhichWeek {


    /**
     * 开学日期位于一年的第几天
     */
    private static int SCHOOL_START_DAY = TimeUtil.dayOfYear(2020, 3, 1);


    /**
     * 计算第几周
     *
     * @param day 希望计算的date
     * @return 返回具体的第几周
     * @apiNote 通过给定一个日期，就算这个日期是开学之后的第几周
     */
    public static int getWeek(JDateTime day) {
        //day位于一年中的第几天
        int expectDay = TimeUtil.dayOfYear(day.getYear(), day.getMonth(), day.getDay());
        //相差多少天
        int offSet = expectDay - SCHOOL_START_DAY;
        //相差的天数除以7还剩多少天
        int modNumber = offSet % 7;
        //相差的天数是由多少个7天组成的
        int result = offSet / 7;
        if (modNumber >= 1) {
            return result + 1;
        } else {
            return result;
        }
    }


    public static void main(String[] args) {
        //期望的日期
        JDateTime expectDate = new JDateTime("2020-05-05");
        //现在的日期
        JDateTime now = new JDateTime();
        System.out.println("日期" + now.toString() + "：：：是第" + getWeek(now) + "周,是周" + now.getDayOfWeek());
        System.out.println("日期" + expectDate.toString() + "：：：是第" + getWeek(expectDate) + "周,是周" + expectDate.getDayOfWeek());
    }
}
