package leetcode;

public class Solution7 {
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diff = leftHeight - rightHeight;
        if (!(diff == -1 || diff == 0 || diff == 1)) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
