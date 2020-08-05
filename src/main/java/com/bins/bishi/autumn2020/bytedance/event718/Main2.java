package com.bins.bishi.autumn2020.bytedance.event718;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/18 21:09
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给一个字符串url
     * 2.字符串可能是这样子的：https://www.bytedance.com/app/1
     * 3.要你判断这个url中是否有一个有效的主机地址host
     * 4.无效的话就输出："Invalid"
     * 5.比如这个用例输出：www.bytedance.com
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        //先通过://判断是否是一个有效的url
        String[] urls = url.split("://");
        if (urls.length <= 1 || urls.length > 2) {
            System.out.println("'Invalid");
        }
        //得到一个有效的url
        String validUrl = urls[1];
        String[] hosts = validUrl.split("/");
        String host = hosts[0];
        String[] strs = host.split(".");
        if (strs.length < 1 || strs.length >= 3) {
            System.out.println("Invalid");
        } else {
            System.out.println(host);
        }
    }

}
