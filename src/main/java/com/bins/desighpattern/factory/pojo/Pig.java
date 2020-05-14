package com.bins.desighpattern.factory.pojo;

/**
 * @author leo-bin
 * @date 2020/1/2 17:17
 * @apiNote
 */
public class Pig extends AbstractAnimal {

    /**
     * 猪的名字
     */
    private String name;

    public Pig(String name) {
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
        System.out.println(name + "是一只猪" + " 爱吃杂食");
    }
}
