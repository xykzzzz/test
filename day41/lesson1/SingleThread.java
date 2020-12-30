package lesson1;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleThread {
    public static void main(String[] args) {
        //第一种情况：耗时多的任务 处理 并发并行执行提高效率 ?思考什么因素影响多线程效率 根据那先因素设计多线程数量
        calculate(new ArrayList<>());
        calculate(new ArrayList<>());
        //第二种情况 ：阻塞任务
        Scanner sc=new Scanner(System.in);
        print(sc);
        print(sc);
        //上面两种情况考虑使用多线程 让后续代码能够执行

    }

    public static int calculate(ArrayList<Object> objects) {
        return 0;
        //计算量非常大，加入执行一次耗时5s
    }
    public static void print(Scanner sc){
            System.out.println(sc.nextLine());
    }
}
