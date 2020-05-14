package com.bins.desighpattern.factory.commonfactory;

import com.bins.desighpattern.factory.pojo.AbstractAnimal;
import com.bins.desighpattern.factory.pojo.Pig;

/**
 * @author leo-bin
 * @date 2020/1/2 17:27
 * @apiNote 猪工厂，专门用来生产猪
 */
public class PigFactory implements AnimalFactory {

    /**
     * 创建一只带名字的小猪
     */
    @Override
    public AbstractAnimal createAnimal(String name) {
        return new Pig(name);
    }
}
