package cengxu;

public class BuildTree {
    public static TreeNode BuildTree1() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;

        return a;

    }
//    public static TreeNode1 BuildTree2() {
//        TreeNode1 a = new TreeNode1('A');
//        TreeNode1 b = new TreeNode1('B');
//        TreeNode1 c = new TreeNode1('C');
//        TreeNode1 d = new TreeNode1('D');
//        TreeNode1 e = new TreeNode1('E');
//        TreeNode1 f = new TreeNode1('F');
//        TreeNode1 g = new TreeNode1('G');
//        TreeNode1 h = new TreeNode1('H');
//        TreeNode1 i = new TreeNode1('I');
//
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        c.left = e;
//        c.right = f;
//        d.left = g;
//        d.right = h;
//        e.right = i;
//
//        return a;
//
//    }
}
