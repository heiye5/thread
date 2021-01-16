package udp.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999)).start();//接收
    }
}
