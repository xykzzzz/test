package priority;

public class MyPriorityQueue {
    private Integer[] array;
    private int size;
    public MyPriorityQueue(){
        array=new Integer[100];
        size=0;
    }
    public Integer element(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        return array[0];
    }
    public Integer remove(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        int e=array[0];
        array[0]=array[size-1];
        size--;
        adjustDown(0);
        return e;
    }
    public void add(Integer e){
        array[size]=e;
        size++;
        adjustUp(size-1);
    }

    private void adjustDown(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            if (leftChildIndex >= size) {
                return;
            }
            int rightChildIndex = leftChildIndex + 1;
            int minChildIndex = leftChildIndex;
            if (rightChildIndex < size && array[rightChildIndex] < array[leftChildIndex]) {
                minChildIndex = rightChildIndex;
            }
            if (array[index] <= array[minChildIndex]) {
                return;
            }
            int t = array[minChildIndex];
            array[minChildIndex] = array[index];
            array[index] = t;
            index = minChildIndex;
        }
    }
    private void adjustUp(int index){
        while (true){
            if(index==0){
                return;
            }
            //找到Index位置的父亲位置 parentIndex
            int parentIndex=(index-1)/2;
            //出口 满足堆的性质 父亲的值小于左右孩子
            if(array[parentIndex]<array[index]){
                break;
            }
            // 不满足 交换index位置与parentIndex位置上的元素
            int t=array[parentIndex];
            array[parentIndex]=array[index];
            array[index]=t;
        }
    }

}
