package leetcode;

import java.util.*;

class Solution1 { //letCode中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root!=null){
            List<Integer> leftSubTreeNode=inorderTraversal(root.left);
            list.addAll(leftSubTreeNode);
            list.add(root.v);
            List<Integer> rightSubTreeNode=inorderTraversal(root.right);
            list.addAll(rightSubTreeNode);
        }
        return list;
    }
}