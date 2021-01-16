package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送方
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("发送中...");
        try {
            //1.使用DatagramSocket指定端口，创建发送端
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            //2.准备数据并转成字节数组
            String data = "字节数组";
            byte[] datas = data.getBytes();
            //3.封装成DatagramPacket包裹，需要指定目的端口
            DatagramPacket packer = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",9999));
            //4.发送包裹send(DatagramPacket p)
            datagramSocket.send(packer);
            //5.释放资源
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
