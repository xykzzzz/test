package treenode;

public class SomeMethod {
    private static int n;
    public static int sumTreeNodeSize(TreeNode root){ //求树的节点采用遍历思路
        n=0;
        preOrder(root);
        return n;
    }
    public static int sumTreeNodeSize2(TreeNode root){ // 求树的节点采用汇集思路
        if(root==null){
            return 0;
        }else{
            int nodeRootSize=1;
            int leftSubNodeSize=sumTreeNodeSize2(root.left);
            int rightSubNodeSize=sumTreeNodeSize2(root.right);
            return nodeRootSize+leftSubNodeSize+rightSubNodeSize;//根+左子树+右子树
        }
    }

    private static void preOrder(TreeNode root) {
        if(root!=null){
            n++; // 遍历这个过程会经过每个节点
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private static int leafN;
    private static int sumTreeLeafNodeSize(TreeNode root){ //求树中叶子节点个数采用遍历思路
        // 注意，每次计算叶子结点个数之前，都必须归零
        leafN = 0;

        // 2. 使用前序遍历方式，经过每一个结点
        preOrder2(root);

        return leafN;
    }
    private static int sumTreeLeafNodeSize2(TreeNode root){//求树中叶子节点个数采用汇集思路
        if(root==null){
            return 0; // 空树
        }else if(root.left==null&&root.right==null){
            return 1; //只有一个结点
        }else{
            // 至少一个以上的结点
            // 整棵树的叶子结点个数 = 左子树的叶子节点个数 + 右子树的叶子结点个数
            int leftSubTreeLeafSize = sumTreeLeafNodeSize2(root.left);
            int rightSubTreeLeafSize = sumTreeLeafNodeSize2(root.right);

            return leftSubTreeLeafSize + rightSubTreeLeafSize;
        }
    }

    private static void preOrder2(TreeNode root) {
        if(root!=null){
            if(root.left==null&&root.right==null){
                leafN++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }
    }
    public static int sumKLevelNodeSize(TreeNode root, int k){
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }else{
            int leftSumK_1=sumKLevelNodeSize(root.left,k-1);
            int rightSumK_1=sumKLevelNodeSize(root.right,k-1);
            return leftSumK_1+rightSumK_1;
        }

    }
    public static int getHeight(TreeNode root){ //获取树的高度
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else{
            int leftSubTreeHeight = getHeight(root.left);
            int rightSubTreeHeight = getHeight(root.right);
            return Math.max(leftSubTreeHeight,rightSubTreeHeight)+1;
        }

    }
    public static boolean contains2(TreeNode root, int v){ //树中是否包含v 思路：三个大思路：一空树
                                                           // 二 判断根中节点是否为v
        if(root==null){                                  //三 根中节点部位不为v，先判断左树，在判断右树
            return false;                            // 注意 若左树有不用判断右树
        }
        if(root.v==v){
            return true;
        }
        boolean left = contains2(root.left, v);
        if (left) {
            return true;
        }

        return contains2(root.right, v);
    }
    public static boolean contains1(TreeNode root, int v) {
        if (root == null) {
            // 空树
            return false;
        } else {
            if (root.v == v) {
                // 根里找到了
                // 没必要再去左右子树找了
                return true;
            } else {
                // 根里没找到
                boolean leftSubTreeContains = contains1(root.left, v);
                if (leftSubTreeContains) {
                    // 左子树里找到了
                    // 没必要再去右子树里找了
                    return true;
                } else {
                    // 左子树里也没找到
                    boolean rightSubTreeContains = contains1(root.right, v);
                    if (rightSubTreeContains) {
                        // 右子树里找到了
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTree();
        int sum=sumTreeNodeSize2(root);
        System.out.println(sum);
        int sumLeaf=sumTreeLeafNodeSize2(root);
        System.out.println(sumLeaf);
        int sumK=sumKLevelNodeSize(root,4);
        System.out.println(sumK);
        int heightTree=getHeight(root);
        System.out.println(heightTree);
        System.out.println(contains2(root,'A'));
    }
}
