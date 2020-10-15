package priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main1(String[] args) {
        MyPriorityQueue queue=new MyPriorityQueue();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    public static void main(String[] args) {
        PriorityQueue<Person> queue=new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });
        Person p1=new Person("XIA",18);
        Person p2=new Person("XI",20);
        Person p3=new Person("X",30);
        Person p4=new Person("XYK",40);
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        System.out.println(queue.remove());
    }
}
