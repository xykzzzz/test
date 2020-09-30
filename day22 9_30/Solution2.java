package leetcode;
import java.util.*;
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) { //后序遍历letCode
        List<Integer> list=new ArrayList<>();
        if(root!=null){
            List<Integer> leftSubTreeNode=postorderTraversal(root.left);
            list.addAll(leftSubTreeNode);
            List<Integer> rightSubTreeNode=postorderTraversal(root.right);
            list.addAll(rightSubTreeNode);
            list.add(root.v);
        }
        return list;
    }
}