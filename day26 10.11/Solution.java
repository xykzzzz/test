package cengxu;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode1 {
      int val;
     TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
  }
public class Solution {
    static class NL {
        TreeNode1 node;
        int level;
        NL(TreeNode1 node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode1 root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<NL> queue=new LinkedList<>();
        queue.add(new NL(root,0));
        while (!queue.isEmpty()){
            NL nl = queue.remove();
            TreeNode1 node=nl.node;
            int level= nl.level;
            if(level==list.size()){
                list.add(new ArrayList<>());
            }
            List<Integer> innerList=list.get(level);
            innerList.add(node.val);
            if(node.left!=null){
                queue.add(new NL(node.left,level+1));
            }
            if(node.right!=null){
                queue.add(new NL(node.right,level+1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode1 root=BuildTree.BuildTree2();
        List<List<Integer>> list = levelOrder(root);
        System.out.println(list);
    }
}
