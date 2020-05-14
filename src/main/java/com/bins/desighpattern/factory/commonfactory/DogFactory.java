package com.bins.desighpattern.factory.commonfactory;

import com.bins.desighpattern.factory.pojo.AbstractAnimal;
import com.bins.desighpattern.factory.pojo.Dog;

/**
 * @author leo-bin
 * @date 2020/1/2 17:21
 * @apiNote 狗工厂，专门用来生产狗类动物
 */
public class DogFactory implements AnimalFactory {

    /**
     * 创建一只带名字的狗子
     */
    @Override
    public AbstractAnimal createAnimal(String name) {
        return new Dog(name);
    }
}
