package com.bins.desighpattern.factory;

import com.bins.desighpattern.factory.commonfactory.AnimalFactory;
import com.bins.desighpattern.factory.commonfactory.CatFactory;
import com.bins.desighpattern.factory.commonfactory.DogFactory;
import com.bins.desighpattern.factory.commonfactory.PigFactory;
import com.bins.desighpattern.factory.pojo.AbstractAnimal;

/**
 * @author leo-bin
 * @date 2020/1/2 17:30
 * @apiNote 设计模式测试类
 */
public class Test {

    public static void main(String[] args) {
        //普通工厂模式测试
        commonFactory();
        //简单工厂模式测试
        easyFactory();
        //抽象工厂模式测试
        abstractFactory();
    }

    /**
     * 普通工厂模式
     */
    private static void commonFactory() {
        System.out.println("这是普通工厂模式正在测试中。。。");
        //得到一个狗工厂
        AnimalFactory dogFactory = new DogFactory();
        //生产了一个有名字的狗子
        AbstractAnimal dog = dogFactory.createAnimal("旺财");
        //喂狗吃饭
        dog.eat();

        //得到一个猫工厂
        AnimalFactory catFactory = new CatFactory();
        //生产一只有名字的猫
        AbstractAnimal cat = catFactory.createAnimal("小明");
        //喂猫吃饭
        cat.eat();

        //得到一个猪工厂
        AnimalFactory pigFactory = new PigFactory();
        //生产一只有名字的猪
        AbstractAnimal pig = pigFactory.createAnimal("小红");
        //喂猫吃饭
        pig.eat();
    }

    /**
     * 简单工厂模式
     */
    private static void easyFactory() {
        System.out.println("这是简单工厂模式正在测试中。。。");
        //获得一只狗
        AbstractAnimal dog = com.bins.desighpattern.factory.easyfactory.AnimalFactory.createAnimal("dog", "煤球");
        //喂狗吃饭
        if (dog != null) {
            dog.eat();
        }
    }


    /**
     * 抽象工厂模式
     */
    private static void abstractFactory() {

    }
}
