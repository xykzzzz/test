package 链表;

public class D {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast=head;
        ListNode slow=head;
        if(k<0||head==null){
            return null;
        }
        while (k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else {
                return null;
            }
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
