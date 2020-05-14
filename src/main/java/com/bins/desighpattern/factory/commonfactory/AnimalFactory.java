package com.bins.desighpattern.factory.commonfactory;

import com.bins.desighpattern.factory.pojo.AbstractAnimal;

/**
 * @author leo-bin
 * @date 2020/1/2 17:03
 * @apiNote 普通工厂模式  动物工厂接口 专门生产各种各样的动物
 */
public interface AnimalFactory {

    /**
     * 生产各种类的动物
     */
    AbstractAnimal createAnimal(String name);

}
