package 链表;

public class A {
    //给你一个链表的头节点 head 和一个整数 val ，
    // 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode cur=head.next;
        ListNode prev=head;
        while (cur!=null) {
            if(cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
            }else {
                prev=prev.next;
                cur=cur.next;
            }
        }
        if(head.val==val){
            head=head.next;
        }
        return head;
    }
}
