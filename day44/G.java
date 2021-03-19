package 链表;

public class G {
    //现有一链表的头指针 ListNode* pHead，给一定值x，
    // 编写一段代码将所有小于x的结点排在其余结点之前，
    // 且不能改变原来的数据顺序，返回重新排列后的链表的头指针
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur=pHead;
        ListNode bs=null;
        ListNode be=null;
        ListNode as=null;
        ListNode ae=null;
        while (cur!=null){
            if(cur.val<x){
                if(bs==null){
                    bs=cur;
                    be=bs;
                }else {
                    be.next=cur;
                    be=cur;
                }
            }else {
                if(as==null){
                    as=cur;
                    ae=as;
                }else {
                    ae.next=cur;
                    ae=cur;
                }
            }
            cur=cur.next;
        }
        if(bs==null){
            return as;
        }
        be.next=as;
        if(as!=null){
            ae.next=null;
        }
        return bs;
    }
}
