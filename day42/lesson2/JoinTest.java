package lesson2;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

            //t和main同时并发并行执行,但是因为main线程正在运行态，所以cpu很快执行后续代码
        //打印main和t，本来应该是乱序，但先打印main概率非常高
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {//匿名内部类要使用外部变量，必须是final修饰
                    try {
                        Thread.sleep(3000);
                        System.out.println("t");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });//申请系统创建线程t

        t.start();//申请系统执行线程t，创建态转变为运行态：由系统决定什么时候运行
       //先等1s，打印main 在等2s打印t
        /*t.join(1000);*///当前线程限时等待，直到t线程执行完毕，或给定时间已到

        //先等t执行完，系统调度t由就绪态转变为运行态的时间，加上t的运行时间
        //结果 等3秒打印t，之后直接打印main
        t.join(4000);
        System.out.println("main");
    }
}
