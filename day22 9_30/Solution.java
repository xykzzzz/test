package leetcode;

import treenode.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {   //letCode代码前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root!=null){
            list.add(root.v);
            List<Integer> leftTreeNode = preorderTraversal(root.left);
            list.addAll(leftTreeNode);
            List<Integer> rightTreeNode = preorderTraversal(root.right);
            list.addAll(rightTreeNode);
        }
        return list;
    }
}

