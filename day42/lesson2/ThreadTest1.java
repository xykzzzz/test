package lesson2;

public class ThreadTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int j=i;
            //子线程休眠3秒，同始执行，无序执行
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {//匿名内部类要使用外部变量，必须是final修饰
                    try {
                        Thread.sleep(3000);
                        System.out.println(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        System.out.println("ok");
    }
}
