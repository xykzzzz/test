package leetcodeTreejinjie;

public class Solution2 {
    public static String tree2str(TreeNode t) { //二叉树创建字符串。
        StringBuilder sb=new StringBuilder();
        preorder(sb,t);
        return sb.toString();
    }

    private static void preorder(StringBuilder sb, TreeNode node) {
        if(node!=null){
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                return;
            }else if (node.left != null && node.right == null) {
                sb.append("(");
                preorder(sb, node.left);
                sb.append(")");
            }else {
                sb.append("(");
                preorder(sb, node.left);
                sb.append(")");

                sb.append("(");
                preorder(sb, node.right);
                sb.append(")");
            }
        }
    }
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2; n1.right = n3;
        n2.left = n4;
//        n1.left = n2; n1.right = n3;
//        n2.right = n4;
        System.out.println(tree2str(n1));
    }
}
