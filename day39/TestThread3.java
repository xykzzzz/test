package process.demo;
//多个线程操作同一个对象
//买火车票
//多个线程同时操作一个资源，会造成线程不安全
public class TestThread3 implements Runnable{
    private int ticket=10;
    @Override
    public void run() {
        while (true){
            if(ticket<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket=new TestThread3();
        new Thread(ticket,"高").start();
        new Thread(ticket,"夏").start();
        new Thread(ticket,"王").start();
    }
}
