package leetcode;

public class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) { // letCode相同的树
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.v== q.v&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}