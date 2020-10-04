package packeageDeque;

public class LinkedList implements Deque {
    private static class Node {
        public Integer v;
        Node prev;
        Node next;

        Node(Integer x) {
            v = x;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean offerFirst(Integer e) {
        if (size == 0) {
            head = tail = new Node(e);
        } else {
            Node newNode = new Node(e);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if (size == 0) {
            return null;
        }
        return head.v;
    }

    @Override
    public Integer pollFirst() {
        if (size == 0) {
            return null;
        }
        Integer e = head.v;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;

        return e;
    }

    @Override
    public boolean offerLast(Integer e) {
        if (size == 0) {
            head = tail = new Node(e);
        } else {
            Node newNode = new Node(e);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if (size == 0) {
            return null;
        }
        return tail.v;
    }

    @Override
    public Integer pollLast() {
        if (size == 0) {
            return null;
        }

        Integer e = tail.v;

        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;

        return e;
    }
}
