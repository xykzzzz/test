package leetcodeTreejinjie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static TreeNode buildTree(List<Character> in,List<Character> out){
        if(in.isEmpty()){
            return null;
        }
        char intValue = in.remove(0);
        if(intValue=='#'){
            out.addAll(in);
            return null;
        }
        TreeNode root=new TreeNode(intValue);
        List<Character> rightOut=new ArrayList<>();
        TreeNode left=buildTree(in,rightOut);
        TreeNode right=buildTree(rightOut,out);
        root.left=left;
        root.right=right;
        return root;
    }
    public static List<Character> stringToListChar(String s){
        List<Character> list=new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars) {
            list.add(c);
        }
        return list;
    }
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%c ", root.val);
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Character> in = stringToListChar(s);
        ArrayList<Character> out = new ArrayList<>();
        TreeNode root = buildTree(in, out);
        inOrder(root);
    }
}
