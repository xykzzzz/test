package leetcodelx;

public class MyCircularDeque {
    int[]arr;
    int size;
    int tail;
    int last;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if(k<0){
            throw new IllegalArgumentException();
        }
        this.arr=new int[k];
        this.size=0;
        this.tail=0;
        this.last=0;
    }
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size==arr.length){
            return false;
        }
        if(tail==0){
            arr[arr.length-1]=value;
            tail=arr.length-1;
        }else{
            arr[tail--]=value;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size==arr.length){
            return false;
        }
        arr[last] = value;
        size ++;
        last = last == arr.length - 1 ? 0 : last + 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        tail=tail==arr.length-1?0:tail+1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        last=last==0?arr.length-1:last-1;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return arr[tail];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return last == 0 ? arr[arr.length - 1] : arr[last - 1];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==arr.length;
    }
}