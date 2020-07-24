package com.bins.javabasic.net.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author leo-bin
 * @date 2020/7/24 15:20
 * @apiNote 通过socket创建的客户端
 */
public class SocketClient {


    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 9999;

        try (Socket client = new Socket(host, port);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream())) {

            //1.客户端发送消息给指定服务端
            objectOutputStream.writeObject("你好，我是客户端！");

            //2.客户端接受到来自服务端的消息
            Object result = objectInputStream.readObject();

            System.out.println("这是来自服务端的消息：" + result.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
