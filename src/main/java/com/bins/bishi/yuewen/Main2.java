package com.bins.bishi.yuewen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/5/19 18:59
 * @apiNote 第二题
 */
public class Main2 {


    /**
     * 题目描述：
     * 1.根据产品策略某本书可以设置包月到期时间
     * 2.需要计算指定时间到包月到期时间还有多少分钟
     * 3.不足60S的不计入
     * <p>
     * 输入描述:
     * 输入共两行
     * 第一行为指定时间，格式为 2020-02-01 12:00:00
     * 第二行为到期时间，格式为 2020-02-01 12:01:00
     * <p>
     * 输出描述:
     * 输出参数为一行，为剩余分钟如1
     * <p>
     * 输入
     * 2020-02-01 12:00:00
     * 2020-02-01 12:01:00
     * 输出
     * 1
     *
     * @apiNote 思路：
     * 1.时间日期的转换
     * 2.
     */
    public static int main2(Date targetDate, Date deadDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(targetDate);
        calendar2.setTime(deadDate);
        long target = calendar1.getTimeInMillis();
        long dead = calendar2.getTimeInMillis();
        //计算差多少毫秒
        long left = dead - target;
        return (int) left / (60 * 1000);
    }


    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        String targetDateStr = scanner.nextLine();
        String deadDateStr = scanner.nextLine();

        Date targetDate = null;
        Date deadDate = null;
        try {
            targetDate = format.parse(targetDateStr);
            deadDate = format.parse(deadDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(main2(targetDate, deadDate));
    }
}
