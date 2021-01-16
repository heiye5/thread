package threa;

public class RunableTest implements Runnable{
    public static void main(String[] args) {
        RunableTest runableTest = new RunableTest();
        Thread t = new Thread(runableTest);
        t.start();

        for(int i=0;i<400;i++){
            System.out.println("er");
        }
    }


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("dshf");
        }
    }
}
