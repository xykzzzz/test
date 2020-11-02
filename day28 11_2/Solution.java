package maptest;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点
public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> newOldMapping=new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });
        Node fakeHeadNode=new Node(-1);
        Node tail=fakeHeadNode;
        Node current=head;
        while (current!=null){
            Node newNode=new Node(current.val);
            tail.next=newNode;
            tail=newNode;
            newOldMapping.put(current,newNode);
            current=current.next;
        }
        Node oldCurrent=head;
        Node newCurrent=fakeHeadNode.next;
        while (oldCurrent!=null){
            Node oldRandom=oldCurrent.random;
            Node newRandom ;
            if(oldRandom==null){
                newRandom=null;
            }else {
                newRandom = newOldMapping.get(oldRandom);
            }
            newCurrent.random=newRandom;
            oldCurrent=oldCurrent.next;
            newCurrent=newCurrent.next;
        }
        return fakeHeadNode.next;
    }
}
