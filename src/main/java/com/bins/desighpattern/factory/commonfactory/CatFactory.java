package com.bins.desighpattern.factory.commonfactory;

import com.bins.desighpattern.factory.pojo.AbstractAnimal;
import com.bins.desighpattern.factory.pojo.Cat;

/**
 * @author leo-bin
 * @date 2020/1/2 17:26
 * @apiNote 猫工厂，专门用来生产猫
 */
public class CatFactory implements AnimalFactory {

    /**
     * 创建一只带名字的猫
     */
    @Override
    public AbstractAnimal createAnimal(String name) {
        return new Cat(name);
    }
}
