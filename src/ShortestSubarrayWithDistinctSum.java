import java.util.HashMap;
import java.util.Map;

public class ShortestSubarrayWithDistinctSum {
    public static void main(String[] args) {
        int[] nums = {5,5,4};
        int k = 5 ;

        System.out.println(minLength(nums , k));
    }

    public static int minLength(int[] nums , int k){
        int n = nums.length;
        int sum = 0;
        int low = 0;
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int high = 0 ; high<n; high++){
            int val = nums[high];

            map.put(val , map.getOrDefault(val,0)+1);
            if(map.get(val) == 1){
                sum += val;
            }

            while(sum>= k){
                res = Math.min(res, high-low+1);
                int removeVal = nums[low];
                map.put(removeVal, map.getOrDefault(removeVal,0)-1);
                if(map.get(removeVal) == 0){
                    sum -= removeVal;
                }
                low++;
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res ;
    }
}

// Question Link -> https://leetcode.com/problems/minimum-subarray-length-with-distinct-sum-at-least-k/
