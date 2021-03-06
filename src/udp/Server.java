package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("正在接收中...");

        try {
            //1.使用DataDatagramSocket指定端口，创建接收端
            DatagramSocket datagramSocket = new DatagramSocket(9999);           //端口9999与发送端目的端口相同
            //2.准备容器，封装成DatagramPacket包裹
            byte[] container = new byte[1024*60];
            DatagramPacket datagramPacket = new DatagramPacket(container,0,container.length);
            //3.阻塞式接收包裹receive（DatagramPacker p）
            datagramSocket.receive(datagramPacket);     //阻塞式
            //4.分析数据
            byte[] datas = datagramPacket.getData();
            System.out.println(new String(datas,0,datagramPacket.getLength()));
            //5.释放资源
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
