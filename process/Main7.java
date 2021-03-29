package 线程.lesson1;

public class Main7 {
    static volatile boolean flag=true;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 10000&&!flag; i++) {
                            System.out.println(i);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
           System.out.println("start");
            Thread.sleep(5000);
            flag=false;
        System.out.println("end");
        System.out.println("main");
    }
}
