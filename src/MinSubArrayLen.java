public class MinSubArrayLen {
    public static void main(String[] args) {

        int[] nums = {1,4,4};
        int target = 4 ;

        System.out.println(minSubArrayLen(nums , target));
    }

    public static int minSubArrayLen(int[] nums, int target) {

        int n = nums.length;
        int len = Integer.MAX_VALUE;

        int low = 0 ;
        int high = 0 ;
        int sum = 0 ;

        while(high < n){
            sum += nums[high];
            while(sum>=target){
                len = Math.min(len , high-low+1);
                sum -= nums[low];
                low++;
            }
            high++;
        }

        if(len == Integer.MAX_VALUE){return 0;}

        return len ;
    }
}

// Question Link -> https://leetcode.com/problems/minimum-size-subarray-sum/
