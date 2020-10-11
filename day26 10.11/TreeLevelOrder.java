package cengxu;


import java.util.LinkedList;
import java.util.Queue;


public class TreeLevelOrder {
    public static void levelOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        //队列元素的元素是树的结点
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){ //把树的结点拖入队列在删除时候在托入他的左右孩子 以此循环
            TreeNode node =  queue.remove();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    public static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (true){
            TreeNode node = queue.remove();
            if(node==null){
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node==null){
            }
            else{
                return false;
            }
        }
        return true;
    }
    static class Nl{
        int level;
        TreeNode node;

        public Nl(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }
    public static void levelOrderWithLevel(TreeNode root){
        if(root==null){
            return;
        }
        Queue<Nl> queue=new LinkedList<>();
        queue.add(new Nl(root,1));
        while (!queue.isEmpty()){
            Nl nl = queue.remove();
            TreeNode node=nl.node;
            int level= nl.level;
            System.out.println(level);
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(new Nl(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Nl(node.right, level + 1));
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.BuildTree1();
        levelOrderTraversal(root);
        System.out.println(isCompleteTree(root));
        levelOrderWithLevel(root);
    }
}
