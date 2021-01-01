package lesson2;

public class ThreadTest2 {
/*    public static void main(String[] args) {
        //main主线程和子线程同时执行
        for (int i = 0; i <20; i++) {
            final int j = i;
            //子线程休眠3秒，同始执行，无序执行
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {//匿名内部类要使用外部变量，必须是final修饰
                    System.out.println(j);
                }
            });
            t.start();
        }
        System.out.println("ok");
    }*/
    public static void main(String[] args) throws InterruptedException {
        //main主线程和子线程同时执行
        Thread[] threads=new Thread[20];
        for (int i = 0; i <20; i++) {
            final int j = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {//匿名内部类要使用外部变量，必须是final修饰
                    System.out.println(j);
                }
            });
        }
        for (Thread t:threads) {
            t.start();
            /*t.join(); 一个启动执行完在启动下一个*/
        }
        //子线程执行完，在执行主线程代码
        for (Thread t:threads) {//同时执行20个线程
            t.join();//等待20个线程执行完毕
        }
        System.out.println("ok");
    }
}
