package lesson2;

public class InterruptTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //执行任务，执行时间可能比较长
                //中断以后停止程序
                //Thread.interrupted()；返回当前线程中断标志，然后重置t线程标志位
                for (int i = 0; i < 10000; i++) {
                    System.out.println(i+":"+Thread.interrupted());
                }
            }
            }
        );
        t.start();//线程启动，中断标志位为false
        System.out.println("t start");
        t.interrupt();
        //告诉t线程要中断（设置t线程终端的标志位为true），由t线程中代码决定是否中断
        //如果t线程处于阻塞状态，会抛出InterruptedException，并且重设t线程的中断标志
        System.out.println("t stop");
    }
}
