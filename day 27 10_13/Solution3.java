package leetcodeTreejinjie;

public class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){  //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
            return root;
        }
        boolean PLeft=search(root.left,p);
        boolean QLeft=search(root.left,q);
        if(PLeft&&QLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!PLeft&&!QLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    private boolean search(TreeNode root, TreeNode t) {
        if(root==null){
            return false;
        }
        if(root==t){
            return true;
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }
}
