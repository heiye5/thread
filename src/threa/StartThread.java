package threa;

/**
 * 线程
 */
public class StartThread extends Thread{

    @Override
    public void run() {
        for (int i=0;i<3000;i++){
            System.out.println("xinacheng");
        }
    }

    public static void main(String[] args) {


        StartThread st = new StartThread();
        st.start();

        for (int i=0;i<3000;i++){
            System.out.println("x");
        }
    }
}
