package 链表;

public class B {
    //反转
    public ListNode reverseList(ListNode head) {
        ListNode newNode=null;
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newNode=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newNode;
    }
}
