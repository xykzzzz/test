package lesson2;

public class StopThreadTest {
    private static  volatile boolean STOP=false;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //执行任务，执行时间可能比较长
                for (int i = 0; i < 10000&&!STOP; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                        //通过标志位自行实现，无法解决线程阻塞导致无法中断
/*                        Thread.sleep(1000);*/
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        System.out.println("t start");
        //模拟t执行5s，要中断停止t线程
        Thread.sleep(5000);
        STOP=true;
        System.out.println("t stop");
    }
}
