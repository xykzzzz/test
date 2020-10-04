package packeageDeque;

public class testDeque {
    public static void main(String[] args) {
        Deque deque=new LinkedList();
        //测试栈的功能
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        System.out.println(deque.peek());   // 5
        System.out.println(deque.peek());   // 5
        System.out.println(deque.pop());    // 5
        System.out.println(deque.pop());    // 4
        System.out.println(deque.pop());    // 3
        deque = new LinkedList();
        //测试队列的功能
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        System.out.println(deque.element());    // 1
        System.out.println(deque.element());    // 1
        System.out.println(deque.remove());     // 1
        System.out.println(deque.remove());     // 2
    }
}
