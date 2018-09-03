package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//TCP编程例三：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
//如下的程序，处理异常时，要使用try-catch-finally!!本例仅为了书写方便~

public class TestTCP3 {
    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            // 1.创建Socket的对象
            socket = new Socket(InetAddress.getByName("192.168.2.102"), 8989);
            // 2.从本地获取一个文件发送给服务端
            File file = new File("1.jpg");
            fis = new FileInputStream(file);
            os = socket.getOutputStream();

            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
            socket.shutdownOutput();

            // 3.接收来自于服务端的信息
            is = socket.getInputStream();
            byte[] b1 = new byte[1024];
            int len1;
            while ((len1 = is.read(b1)) != -1) {
                String str = new String(b1, 0, len1);
                System.out.print(str);
            }
        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            // 4.关闭相应的流和Socket对象
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            // 1.创建一个ServerSocket的对象
            ss = new ServerSocket(8989);
            // 2.调用其accept()方法，返回一个Socket的对象
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("3.jpg"));
            os = socket.getOutputStream();

            // 3.将从客户端发送来的信息保存到本地
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("收到来自于：" + socket.getInetAddress().getHostAddress() + "的文件");

            // 4.发送"接收成功"的信息反馈给客户端
            os.write("发送成功！".getBytes());
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            // 5.关闭相应的流和Socket及ServerSocket的对象
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        }
    }
}
