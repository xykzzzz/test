
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data= data;
    }
}
public class MyLinkedList{
    public Node head;
    ////头插法
    public void addFirst(int data){
        Node node=new Node(data);
        node.next=this.head;
        this.head=node;
    }
    //打印单链表
    public  void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
        }
        else {
            Node cur=this.head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(!cheekIndex(index)){
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==this.getLength()){
            addLast(data);
            return;
        }
        Node cur=searchPrev(index);
        Node node=new Node(data);
        node.next=cur.next;
        cur.next=node;
    }
    public int getLength(){
        int count=0;
        Node cur=this.head;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public boolean cheekIndex(int index){
        if(index<0||index>getLength()){
            System.out.println("下标不合法！");
            return false;
        }
        return true;
    }
    public Node searchPrev(int index){
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    //删除第一次出现关键字为key的节点
     public void remove(int key){
        if(this.head==null){
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        Node cur=searchPreNode(key);
        if(cur==null){
            System.out.println("没有你要删除的数字！");
            return;
        }
        Node del=cur.next.next;
        cur.next=del;

     }
     public Node searchPreNode(int key){
        Node cur=this.head;
        while (cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //查找是否包含关键字key是否在单链表当中
   public boolean contains(int key){
        Node cur=this.head;
        if(this.head.data==key){
            return true;
        }
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
   }
    //删除链表中等于给定值 **key** 的所有节点
    public void removeAllKey(int key) {
        if(this.head==null){
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }
            else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }
    // 反转一个单链表
    public Node reverseList(){
        Node prev=null;
        Node newHead=null;
        Node cur=this.head;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }

            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    public Node middleNode(){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //输入一个链表，输出该链表中倒数第k个结点
 public Node lastK(int k){
        Node fast=this.head;
        Node slow=this.head;
        if(k<=0||this.head==null){
            return null;
        }
        while(k-1>0){
            if(fast.next!=null) {
                fast = fast.next;
                k--;
            }
            else {
                System.out.println("k值过大");
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
 }
 public void clear(){
        this.head=null;
 }
 //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        // write code here
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    bs=cur;
                    be=bs;
                    //第一次进行插入(尾插)
                }else {
                    be.next=cur;
                    be=cur;
                }
            }else {
                if(as == null) {
                    //第一次进行插入(尾插)
                    as=cur;
                    ae=as;
                }else {
                    ae.next=cur;
                    ae=cur;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node deleteDuplication(){
        Node newHand=new Node(-1);
        Node tmp=newHand;
        Node cur=this.head;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while (cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }
            else {
                tmp.next=cur;
                tmp=cur;
                cur=cur.next;
            }
        }
        tmp.next=null;
        return newHand.next;
    }
    // 链表的回文结构
    public boolean chkPalindrome(){
        if(this.head==null){
            return false;
        }
        if(this.head.next==null){
            return true;
        }
        Node fast=this.head;
        Node slow=this.head;
        while (fast.next!=null||fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node cur=slow.next;
        while (cur!=null) {
            Node curNext=cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (slow!=this.head){
            if(this.head.data==slow.data){
                return true;
            }
            if(this.head.next==slow){
                return true;
            }
            slow=slow.next;
            this.head=this.head.next;
        }
        return false;
    }
//判断链表中是否有环
    public boolean hasCycle()
    {
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
               /* fast = this.head;*/
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;

        while (slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //输入两个链表，找出它们的第一个公共结点
   public Node getIntersectionNode(Node headA,Node headB){
        if(headA==null||headB==null){
            return null;
        }
        int lenA=0;
        int lenB=0;
        Node pl=headA;
        Node ps=headB;
        while (pl!=null){
            pl=pl.next;
            lenA++;
        }
        while (ps!=null){
            ps=ps.next;
            lenB++;
        }
       pl=headA;
        ps=headB;
        int len=lenA-lenB;
        if(len<0){
            pl=headB;
            ps=headA;
            len=lenB-lenA;
        }
        while (len>0){
            pl=pl.next;
            len--;
        }
       while (pl != null && ps != null && pl != ps) {
           pl = pl.next;
           ps = ps.next;
       }
       if(pl == ps && pl != null) {
           return pl;
       }
       return null;
    }
    public void createCut(Node headA, Node headB) {
        headA.next = headB.next.next;
    }
    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public static Node mergeTwoLists(Node headA, Node headB){
        Node newHead=new Node(-1);
        Node tmp=newHead;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            }
            else{
                tmp.next=headB;
                tmp=tmp.next;
                headB=headB.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        }
        if(headB!=null){
            tmp.next=headB;
        }
        return newHead.next;
    }

}


