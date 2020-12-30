package lesson1;

public class ThreadLook5 {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if(i==20){
                        //莫个线程抛出异常，如果抛到run方法，整个线程直接终止，
                        //但是不会影响其他线程
                        //线程中，处理异常的方式:线程对象t.setUncaughtExceptionHandler()
                        //或者自己在run()方法中捕获并处理
                        throw new RuntimeException();
                    }
                    System.out.println(i);
                }
            }
        };
        t.start();
        while (true){

        }
    }
}
