package udp.chat;

/**
 * 加入多线程，实现双向交流
 */
public class TalkStudent {
    public static void main(String[] args) {
        //启动线程
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送

    }
}
