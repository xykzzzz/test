package newArraylist;

import interator.interable.List;
import interator.interable.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);


    }
}
