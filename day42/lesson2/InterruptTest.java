package lesson2;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000&&!Thread.currentThread().isInterrupted(); i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                        //通过标志位自行实现，无法解决线程阻塞导致无法中断
                        //*                        Thread.sleep(10000000);*//*
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //执行任务，执行时间可能比较长
                //中断以后停止程序
    /*            try {
                    for (int i = 0; i < 10000&&!Thread.currentThread().isInterrupted(); i++) {
                        System.out.println(i);
                        //模拟中断线程
                            Thread.sleep(1000);
                            //通过标志位自行实现，无法解决线程阻塞导致无法中断
                        //Thread.sleep(1000);

                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            //中断以后以抛出异常的方式，将标志位重设为false继续执行程序
/*                for (int i = 0; i < 10000&&!Thread.currentThread().isInterrupted(); i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                        //通过标志位自行实现，无法解决线程阻塞导致无法中断
                        *//*                        Thread.sleep(10000000);*//*
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        );
        t.start();//线程启动，中断标志位为false
        System.out.println("t start");
        //模拟t执行5s，要中断停止t线程
        Thread.sleep(5000);
        t.interrupt();
        //告诉t线程要中断（设置t线程终端的标志位为true），由t线程中代码决定是否中断
        //如果t线程处于阻塞状态，会抛出InterruptedException，并且重设t线程的中断标志
        System.out.println("t stop");
    }
}
