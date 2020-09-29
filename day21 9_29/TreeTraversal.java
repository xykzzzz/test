package treenode;

public class TreeTraversal {
    public static void preTraversal(TreeNode root){
        if(root!=null){
            System.out.printf("%c",root.v);
            preTraversal(root.left);
            preTraversal(root.right);
        }
    }
    public static void inTraversal(TreeNode root){
        if(root!=null){
            inTraversal(root.left);
            System.out.printf("%c",root.v);
            inTraversal(root.right);
        }
    }
    public static void postTraversal(TreeNode root){
        if(root!=null){
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.printf("%c",root.v);
        }
    }
    public static void main(String[] args) {
        TreeNode a=BuildTree.buildTree();
        System.out.printf("前序遍历: ");
        preTraversal(a);
        System.out.println();

        System.out.printf("中序遍历: ");
        inTraversal(a);
        System.out.println();

        System.out.printf("后序遍历: ");
        postTraversal(a);
        System.out.println();
    }
}
