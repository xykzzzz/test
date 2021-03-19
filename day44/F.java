package 链表;

public class F {
    public int findKthLargest(int[] nums, int k) {
        return findInterval(nums,0,nums.length-1,k);
    }

    private int findInterval(int[] nums, int low, int high, int k) {
        int index=partition(nums,low,high);
        if(index-low+1==k){
            return nums[index];
        }else if(index-low+1>k){
            return findInterval(nums,low,index-1,k);
        }else {
            return findInterval(nums,index+1,high,k-index+low-1);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int key=nums[low];
        int left=low;
        int right=high;
        while (left<right){
            while (nums[right]<=key&&left<right){
                right--;
            }
            while (nums[left]>=key&&left<right){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=nums[low];
        nums[low]=nums[left];
        nums[left]=temp;
        return left;
    }

}
