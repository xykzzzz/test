package leetcodeTreejinjie;

import java.util.ArrayList;
import java.util.List;
public class Solution1 {
    public List<Integer> intArrayToList(int[]array){
        List<Integer> list=new ArrayList<>();
        for(int x:array){
            list.add(x);
        }
        return list;
    }
    private  TreeNode buildTreeInternal(List<Integer> inList, List<Integer> postList){
        if(postList.isEmpty()){
            return null;
        }
        int rootVal = postList.get(postList.size()-1);
        TreeNode root=new TreeNode(rootVal);
        if(postList.size()==1){
            return root;
        }
        int leftSize = inList.indexOf(rootVal);
        // 切割
        // 左子树的后序 + 右子树的后序
        List<Integer> leftPost = postList.subList(0,leftSize);
        List<Integer> rightPost = postList.subList(leftSize, postList.size()-1);
        // 左子树的中序 + 右子树的中序
        List<Integer> leftIn = inList.subList(0, leftSize);
        List<Integer> rightIn = inList.subList(leftSize + 1, inList.size());
        // 分别再去构建左右子树
        root.left = buildTreeInternal(leftIn, leftPost);
        root.right = buildTreeInternal(rightIn,  rightPost);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inList=intArrayToList(inorder);
        List<Integer> postList=intArrayToList(postorder);
        return buildTreeInternal(inList,postList);

    }
}
