package com.bins.desighpattern.factory.pojo;

/**
 * @author leo-bin
 * @date 2020/1/2 17:16
 * @apiNote 猫实体类
 */
public class Cat extends AbstractAnimal {

    /**
     * 猫的名字
     */
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + "是一只猫" + " 爱吃鱼");
    }
}
