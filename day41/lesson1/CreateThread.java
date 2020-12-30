package lesson1;

public class CreateThread {
    public static void main(String[] args) {
        Runnable r=new Runnable() {//任务描述的可执行类,传入线程对象的构造方法
            @Override
            public void run() {
              //线程运行态时执行
            }
        };
        Thread t=new Thread(r,"子线程a");
        t.start();
        //合并代码
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        },"子线程b").start();
        //lambda表达式,runnable接口中只有个一方法,可以使用lambda表达式

        new Thread(()->{
            System.out.println("x");
        },"子线程c").start();
    }
}
