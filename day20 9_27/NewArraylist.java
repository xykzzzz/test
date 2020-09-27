package newArraylist;

public class NewArraylist implements List {
    private int[] array;    // 顺序表内部的数组
    private int size;       // 顺序表内部的元素个数
    public NewArraylist() {
        // 初始容量是 10 个
        array = new int[10];
        // 初始的元素个数是 0 个
        size = 0;
    }
    public NewArraylist(List other) {
        array=new int[other.size()];
        for (int i = 0; i <other.size() ; i++) {
            array[i]=other.get(i);
        }
        size=other.size();
    }
    @Override
    public Boolean add(Integer e) {
        if(array.length==size){
            ensureCapacity(array.length*2);
        }
        array[size++]=e;
        return true;
    }

    public void ensureCapacity(int capacity) {
        if(array.length>=capacity){
            return;
        }
        int[]newArray=new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i]=array[i];
        }
        this.array=newArray;
    }

    @Override
    public void add(int index, Integer e) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标不合法:"+index);
        }
        if(array.length==size){
            ensureCapacity(array.length*2);
        }
        for (int i = this.size-1; i>=index ; i--) {
            array[i+1]=array[i];
        }
    }

    @Override
    public Integer remove(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标不合法:"+index);
        }
        int e=array[index];
        for (int i = index; i <size-1 ; i++) {
            array[i]=array[i+1];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {
        int index=indexOf(e);
        if (index!=-1){
            remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Integer get(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标不合法:"+index);
        }
        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标不合法:"+index);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i <size ; i++) {
            array[i]=0;
        }
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean Contains(Integer e) {
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i <size ; i++) {
            sb.append(array[i]);
            if(i!=size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
