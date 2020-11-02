package maptest;

public class MyMap {
    private TreeNode root;
    Integer getOrDefault(String key,Integer getOrDefault){
        if(get(key)!=null){
            return get(key);
        }
        return getOrDefault;
    }
    Integer put(String key,Integer value){
        TreeNode parent=null;
        TreeNode current=root;
        if(root==null){
            root=new TreeNode(key,value);
            return null;
        }
        while (current!=null){
            int cmp = key.compareTo(current.key);
            if(cmp==0){
                Integer v = get(key);
                current.value=value;
                return v;
            }else if(cmp<0){
                parent=current;
                current=current.left;
            }else{
                parent=current;
                current=current.right;
            }
        }
        TreeNode newNode=new TreeNode(key,value);
        int cmp = key.compareTo(parent.key);
        if (cmp<0){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }

        return null;
    }
    Integer get(String key){
        TreeNode current=root;
        while (current!=null){
            int cmp = key.compareTo(current.key);
            if(cmp==0){
                return current.value;
            }else if(cmp<0){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        return null;
    }
}
