

public class TestDemo {
  /*  public Node getIntersectionNode(Node headA,Node headB){
        while (this.head)
    }*/
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        MyLinkedList myLinkedList1=new MyLinkedList();
       /* myLinkedList.addFirst(1);
        myLinkedList.display();*/
    /*   myLinkedList.addIndex(0,1);
        myLinkedList.addIndex(1,2);*/
        /*myLinkedList.addIndex(0,5);*/
/*
       myLinkedList.display();
       myLinkedList.addFirst(1);
       myLinkedList.addLast(2);
       myLinkedList.addLast(3);
       myLinkedList.addLast(4);
       myLinkedList.addLast(5);
     *//*  myLinkedList.display();
       myLinkedList.remove(1);*//*
       myLinkedList.display();
       myLinkedList.reverseList();
       myLinkedList.display();*/
    /*    System.out.println(myLinkedList.contains(5));*/
       /* myLinkedList.removeAllKey(5);
        myLinkedList.display();*/
        /*Node x=myLinkedList.middleNode();*/
       /* Node x=myLinkedList.lastK(3);
        System.out.println(x);*/
       /* myLinkedList.reverseList();
        myLinkedList.display();*/
      /*  myLinkedList.addFirst(1);
        myLinkedList.addLast(2);
        *//*myLinkedList.addIndex(2,3);*//*
        myLinkedList.addLast(15);
        myLinkedList.addLast(12);
        myLinkedList.addLast(27);*/
      /*  myLinkedList.display();
        myLinkedList.remove(2);
        myLinkedList.display();
        myLinkedList.partition(12);
        myLinkedList.display();
        System.out.println(myLinkedList.chkPa());*/
        myLinkedList.addFirst(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addIndex(1,10);
        myLinkedList.display();
        myLinkedList1.addFirst(1);
        myLinkedList1.addLast(12);
        myLinkedList1.addLast(13);
        myLinkedList.addLast(15);
        myLinkedList.createCut(myLinkedList.head,myLinkedList1.head);
        Node ret=myLinkedList.getIntersectionNode(myLinkedList.head,myLinkedList1.head);
        System.out.println(ret.data);
       /* myLinkedList.display2(myLinkedList.reverseList());*/
       /* myLinkedList.deleteDuplication();
        myLinkedList.display();*/


    }
}
