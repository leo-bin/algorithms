package com.bins.javabasic.enums;

/**
 * @author leo-bin
 * @date 2020/5/12 9:50
 * @apiNote 季节枚举类
 */
public enum Season {

    /**
     * 春
     */
    SPRING(0),

    /**
     * 夏
     */
    SUMMER(1),

    /**
     * 秋
     */
    AUTUMN(2),

    /**
     * 冬
     */
    WINTER(3);


    private int value;


    Season(int value) {
        this.value = value;
    }

    public static Season getNextSeason(Season nowSeason) {
        int nextDayValue = nowSeason.value;
        if (++nextDayValue == 3) {
            nextDayValue = 0;
        }
        return getSeasonByValue(nextDayValue);
    }


    public static Season getSeasonByValue(int value) {
        //Season.values()，拿到枚举类中的所有枚举对象
        for (Season s : Season.values()) {
            if (s.value == value) {
                return s;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        //ordinal()返回具体枚举对象的下标，也就是它在枚举类中的顺序
        System.out.println("nowSeason->" + Season.SPRING + ", value->" + Season.SPRING.ordinal());
        System.out.println("nextSeason->" + Season.getNextSeason(Season.SPRING));
        //toString()和name()方法的效果是一样的，都是返回原枚举类型定义的字符串
        System.out.println("toString()方法测试：：枚举类型SPRING的定义字符串：" + Season.SPRING.toString());
        System.out.println("name()方法测试：：枚举类型SPRING的定义字符串：" + Season.SPRING.name());
    }
}
