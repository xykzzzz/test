package process.demo;
//创建线程的第一种方式 继承Thread类
//重写run()方法
//创建线程对象,调用start()方法开启线程
//下面列子两个线程是同时进行的(交替进行)同一时间只能执行一件事
// 但是由于执行效率问题看起来是同时执行(并发 假同时)
//线程的执行由cpu调度
public class TestThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<20;i++) {
            System.out.println("我是次要的线程");
        }
    }

    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        testThread.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我是主线程");
        }
    }
}
