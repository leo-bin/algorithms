package com.bins.desighpattern.factory.easyfactory;

import com.bins.desighpattern.factory.pojo.AbstractAnimal;
import com.bins.desighpattern.factory.pojo.Cat;
import com.bins.desighpattern.factory.pojo.Dog;

/**
 * @author leo-bin
 * @date 2020/1/2 17:42
 * @apiNote 简单工厂模式  动物工厂
 */
public class AnimalFactory {

    private static final String DOG = "dog";

    private static final String CAT = "cat";

    /**
     * 创建一条狗
     */
    private static Dog createDog(String name) {
        return new Dog(name);
    }

    /**
     * 创建一条狗
     */
    private static Cat createCat(String name) {
        return new Cat(name);
    }

    /**
     * 根据类型创建动物
     */
    public static AbstractAnimal createAnimal(String type, String name) {
        if (type.equals(DOG)) {
            return createDog(name);
        } else if (type.equals(CAT)) {
            return createCat(name);
        } else {
            return null;
        }
    }
}
