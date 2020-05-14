package com.bins.desighpattern.factory.pojo;

/**
 * @author leo-bin
 * @date 2020/1/2 17:12
 * @apiNote 狗实体类
 */
public class Dog extends AbstractAnimal {

    /**
     * 狗的名字
     */
    private String name;

    public Dog(String name) {
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
        System.out.println(name + "是一条狗" + " 爱吃肉");
    }
}
