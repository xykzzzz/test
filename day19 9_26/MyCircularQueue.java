package bracket;

public class MyCircularQueue {
    private final int[]array;
    int size;
    int frontIndex;
    int rearIndex;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array=new int[k];
        size=0;
        frontIndex=0;
        rearIndex=0;
    }
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size==array.length){
            return false;
        }
        array[rearIndex]=value;
        size++;
        rearIndex++;
        if(rearIndex==array.length){
            rearIndex=0;
        }
         return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size==0){
            return false;
        }
        frontIndex++;
        size--;
        if(frontIndex==array.length){
            frontIndex=0;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(size==0){
            return -1;
        }
        return array[frontIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size==0){
            return -1;
        }
        int index=rearIndex-1;
        if(index==-1){
            index=array.length-1;
        }
        return array[index];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==array.length;
    }
}
