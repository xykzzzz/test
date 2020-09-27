package MyLInklist;

import MyLInklist.MyArraylist1;

public class TestDemo {
    public static void main(String[] args) {
        MyArraylist1 myArraylist1=new MyArraylist1();
        myArraylist1.add(0,1);
        myArraylist1.add(1,2);
        myArraylist1.add(2,3);
        myArraylist1.add(3,4);
        myArraylist1.add(4,5);
        myArraylist1.add(5,6);
        myArraylist1.display();
        myArraylist1.remove(2);
        myArraylist1.display();
        myArraylist1.clear();
        myArraylist1.display();
        System.out.println(myArraylist1.search(4));
    }
}
