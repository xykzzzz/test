package hash表;

import java.util.Arrays;
import java.util.Objects;

class Node{
    Integer key;
    Node next;

    public Node(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
public class MyHashTable {
    private Node[] arr=new Node[11];
    int size;
    public boolean insert(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%arr.length;
        Node current=arr[index];
        while (current!=null){
            if(key.equals(current.key)){
                return false;
            }
            current=current.next;
        }
        Node node=new Node(key);
        node.next=arr[index];
        arr[index]=node;
        size++;
        if((size/arr.length)*100>=75){
            扩容();
        }
        return true;
    }

    private void 扩容() {
        Node[] newArr=new Node[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            Node current=arr[i];
            while (current!=null){
                Integer key=current.key;
                int hashValue=key.hashCode();
                int index=hashValue%newArr.length;
                Node node = new Node(key);
                node.next = newArr[index];
                newArr[index] = node;
                current=current.next;
            }
        }
        arr=newArr;
    }

    public boolean remove(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%arr.length;
        Node current=arr[index];
        Node prev=null;
        while (current!=null){
            if(key.equals(current.key)){
                if(prev==null){
                    arr[index]=current.next;
                }else{
                    prev.next=current.next;
                }
                size--;
                return true;
            }
            prev=current;
            current=current.next;
        }
        return false;
    }
    public boolean contains(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%arr.length;
        Node current=arr[index];
        while (current!=null){
            if(key.equals(current.key)){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }


    public static void main(String[] args) {
        MyHashTable test=new MyHashTable();
      int []array={50,98,10,1,2,3,5,9,23};
        for (int x:array) {
            test.insert(x);
        }
        System.out.println(test);
    }
}
