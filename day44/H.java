package 链表;

public class H {
    public ListNode deleteDuplication(ListNode pHead)
    {
      ListNode newNode=new ListNode(-1);
      ListNode temp=newNode;
      ListNode cur=pHead;
      while (cur!=null){
          if(cur.next!=null&&cur.val==cur.next.val){
              while (cur.next!=null&&cur.val==cur.next.val){
                  cur=cur.next;
              }
              cur=cur.next;
          }else {
              temp.next=cur;
              temp=cur;
              cur=cur.next;
          }
      }
      temp.next=null;
      return newNode.next;
    }
}
