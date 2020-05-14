package com.bins.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author leo-bin
 * @date 2020/3/15 17:05
 * @apiNote 自定义序列化和反序列化工具
 */
@Slf4j
public class MySerializeUtil {


    /**
     * 进行序列化
     */
    public static void doSerialize(Object object, String path) {
        try {
            log.info("正在对对象进行序列化。。。");
            //根据指定的path生成一个文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            //根据文件输出流生成一个对象序列化实例
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            //将具体的对象以二进制的格式写入文件中
            outputStream.writeObject(object);
            //关闭文件输出流
            fileOutputStream.close();
            //关闭序列化输出流
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("对象的序列化完成,序列化的数据保存在文件：{}中", path);
    }

    /**
     * 反序列化
     *
     * @param path
     * @return
     */
    public static Object deSerialized(String path) {
        //反序列化结果
        Object object = null;
        try {
            log.info("正在对文件中的内容进行反序列化。。。");
            //根据指定的path找到具体的文件，生成一个文件输入流对象
            FileInputStream fileInputStream = new FileInputStream(path);
            //根据上面生成的文件输入流来生成一个反序列化实例
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //读取文件中的进制数据，进行反序列化
            object = objectInputStream.readObject();
            //关闭文件输入流
            fileInputStream.close();
            //关闭反序列化输入流
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("对象的反序列化完成,反序列的结果为：{}中", object.toString());
        return object;
    }


    public static void main(String[] args) {

    }
}
