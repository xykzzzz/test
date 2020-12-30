package lesson1;

public class ThreadLook2 {
    public static void main(String[] args) {
        Thread t=new Thread("main中的子线程"){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        /*t.setDaemon(true);*/
        //线程要启动，必须要使用start()-》告诉系统调度本线程
        t.start();
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        //至少有一个非守护线程，进程就不会结束
        System.out.println(t.isDaemon());
        System.out.println(t.isInterrupted());
    }
}
