package leetcode;

public class Solution5 { //树的高度汇集思路
    public int maxDepth(TreeNode root) {
       if(root==null){
           return 0;
       }else if(root.left==null&&root.right==null){
           return 1;
       }else{
           int rootNode=1;
           int leftTreeNodeH=maxDepth(root.left);
           int rightTreeNodeH=maxDepth(root.right);
           return Math.max(leftTreeNodeH,rightTreeNodeH)+1;
       }
    }
}
