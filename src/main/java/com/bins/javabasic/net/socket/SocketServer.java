package com.bins.javabasic.net.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leo-bin
 * @date 2020/7/24 15:20
 * @apiNote 通过socket创建的服务端
 */
public class SocketServer {


    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 9999;

        try (ServerSocket server = new ServerSocket()) {
            //1.绑定指定主机和端口并监听
            server.bind(new InetSocketAddress(host, port));

            //2.阻塞的等待客户端的连接请求
            Socket socket = server.accept();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //3.读取来自客户端的消息
            Object content = objectInputStream.readObject();
            System.out.println("这是来自客户端的信息：" + content.toString());

            //4.给客户端回消息
            objectOutputStream.writeObject("很高心见到你！你的消息我已经收到！");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
