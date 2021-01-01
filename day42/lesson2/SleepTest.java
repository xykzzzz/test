package lesson2;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //静态sleep方法 当前代码行所在的线程
                    Thread.sleep(999999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        while (true){

        }

    }
}
