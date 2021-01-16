package udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    private DatagramSocket datagramSocket;

    public TalkReceive(int port){
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接收包裹receive（DatagramPacker p）
            try {
                datagramSocket.receive(datagramPacket);     //阻塞式
                //4.分析数据
                byte[] datas = datagramPacket.getData();
                String data = new String(datas,0, datagramPacket.getLength());
                System.out.println(data);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5.释放资源
        datagramSocket.close();
    }
}
