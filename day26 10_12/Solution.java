package leetcodeTreejinjie;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static TreeNode buildTreeInternal(List<Integer> preList, List<Integer> inList) {
        if(preList.isEmpty()){
            return null;
        }
        int rootVal = preList.get(0);
        TreeNode root=new TreeNode(rootVal);
        if(preList.size()==1){
            return root;
        }
        int leftSize = inList.indexOf(rootVal);
        // 切割
        // 左子树的前序 + 右子树的前序
        List<Integer> leftPre = preList.subList(1, 1+leftSize);
        List<Integer> rightPre = preList.subList(1+leftSize, preList.size());
        // 左子树的中序 + 右子树的中序
        List<Integer> leftIn = inList.subList(0, leftSize);
        List<Integer> rightIn = inList.subList(leftSize + 1, inList.size());

        // 分别再去构建左右子树
        root.left = buildTreeInternal(leftPre, leftIn);
        root.right = buildTreeInternal(rightPre, rightIn);

        return root;

    }

    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> list=new ArrayList<>();
        for (int x:array) {
            list.add(x);
        }
        return list;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        List<Integer> preList=intArrayToList(preorder);
        List<Integer> inList=intArrayToList(inorder);
        return buildTreeInternal(preList, inList);
    }

    public static void main(String[] args) {
        int[] preorder={1,2,3,4,5,6};
        int[] inorder={3,2,1,5,4,6};
        TreeNode root=buildTree(preorder,inorder);
        System.out.println(root);
    }
}