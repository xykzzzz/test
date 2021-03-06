package fuxi;

import java.util.ArrayList;
import java.util.List;

public class KK {

    List<Integer> item=new ArrayList<>();
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return list;
    }

    private void dfs(int i, int[] nums) {
        if(i>=nums.length){
            list.add(new ArrayList<>(item));
            return;
        }
        item.add(nums[i]);
        dfs(i+1,nums);
        item.remove(item.size()-1);
        dfs(i+1,nums);
    }
}
