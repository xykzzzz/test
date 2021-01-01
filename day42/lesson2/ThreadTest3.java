package lesson2;

public class ThreadTest3 {
    public static void main(String[] args) {

            //t和main同时并发并行执行,但是因为main线程正在运行态，所以cpu很快执行后续代码
        //打印main和t，本来应该是乱序，但先打印main概率非常高
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {//匿名内部类要使用外部变量，必须是final修饰
                    System.out.println("t");
                }
            });//申请系统创建线程t
            t.start();//申请系统执行线程t，创建态转变为运行态：由系统决定什么时候运行
        System.out.println("main");
    }
}
