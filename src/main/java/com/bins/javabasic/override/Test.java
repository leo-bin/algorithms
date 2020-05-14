package com.bins.javabasic.override;

import com.bins.util.MySerializeUtil;

/**
 * @author leo-bin
 * @date 2020/3/15 17:30
 * @apiNote 序列化测试
 */
public class Test {

    public static void main(String[] args) {
        Father father = new Father("小明");
        String path = "C:\\tmp\\hello.txt";
        MySerializeUtil.doSerialize(father, path);
        MySerializeUtil.deSerialized(path);
    }
}
