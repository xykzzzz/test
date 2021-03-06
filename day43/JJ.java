package fuxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JJ {
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        int sum=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            int j=i;
            int temp=0;
            while (j>=0){
                temp=temp+nums[j];
                j--;
            }
            if(sum>temp){
                break;
            }
            list.add(nums[i]);
            sum=sum+nums[i];
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{6}));
    }
}
