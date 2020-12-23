package process.demo;
//第二种方式创建线程 Runnable(接口)
public class TestThread2 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i=0;i<20;i++) {
            System.out.println("我是次要的线程");
        }
    }

    public static void main(String[] args) {
        //创建runnable接口实现类对象
        TestThread2 testThread2=new TestThread2();
        //创建线程，通过线程对象来开启我们的线程
       // Thread thread=new Thread(testThread2);
       // thread.start(); 与下面一样
        new Thread(testThread2).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我是主线程");
        }
    }
}
