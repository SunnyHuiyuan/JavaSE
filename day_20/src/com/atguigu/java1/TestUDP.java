package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

//UDP编程的实现
public class TestUDP {

    // 发送端
    @Test
    public void send() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] b = "我是要发送的数据".getBytes();
            DatagramPacket pack = new DatagramPacket(b, 0, b.length, ds.getInetAddress().getByName("192.168.2.102"),
                    9090);

            // 创建一个数据报：每一个数据报不能大于64k，都记录着数据信息，发送端的IP、端口号,以及要发送到
            ds.send(pack);
        } catch (SocketException e) {

            e.printStackTrace();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();

            }
        }
    }

    // 接收端
    @Test
    public void rceive() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket pack = new DatagramPacket(b, 0, b.length);
            ds.receive(pack);

            String str = new String(pack.getData(), 0, pack.getLength());
            System.out.println(str);
        } catch (SocketException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();

            }
        }

    }
}
