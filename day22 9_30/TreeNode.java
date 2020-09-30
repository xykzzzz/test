package leetcode;

public class TreeNode {
    protected int v;
    protected TreeNode left;
    protected TreeNode right;
    protected TreeNode(int v){
        this.v=v;
    }
    @Override
    public String toString() {
        return String.format("%c", v);
    }
}
