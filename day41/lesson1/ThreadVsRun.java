package lesson1;

public class ThreadVsRun {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        }).run();
        //start()会向系统申请启动某个线程,如果该线程处于运行状态，会自动执行run()
        //run()通过Thread或Runnable，定义要执行打代码-线程运行态要执行的代码
        //不调用start(),直接调用run，相当于java对象直接调用普通实例方法
        /**
         * main线程直接调用Thread对象的run方法，会直接在main线程
         * 运行Thread对象run（）-》传入的runnable对象.run()
         * 结过：main线程直接运行while(true)
         */
    }
}
