package leetcodeTreejinjie;

public class Solution4 { //. 二叉树搜索树转换成排序双向链表。
    TreeNode head;
    TreeNode last;
    public void  add(TreeNode node){
        TreeNode newNode=new TreeNode(node.val);
        if(last==null){
            head=newNode;
        }else{
            last.right=newNode;
        }
        newNode.left = last;
        last = newNode;
    }
    private void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            add(node);
            inOrder(node.right);
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        head = last = null;
        inOrder(pRootOfTree);
        return head;
    }
}
