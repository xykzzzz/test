package lesson1;

public class ThreadLook3 {
    public static void main(String[] args) {
        //第一种创建线程的方式：使用Thread类,重写run()
        //main线程中，new了线程对象，匿名内部类Thread子类重写run（）
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){//线程进入运行态之后执行的

                }
            }
        };
        //线程要启动，必须要使用start()-》告诉系统调度本线程
        //申请系统调用，程序由创建态转化为就绪态，神魔时候转变为为运行态？由系统决定
        t.start();
        while (true){

        }
    }
}
