import java.util.Arrays;

public class MinimumDiff {
    public static void main(String[] args) {

      int[] nums = {9,4,1,7};
      int k = 2 ;

      System.out.println(minimumDifference(nums , k));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE ;

        for(int i = k-1 ; i<nums.length; i++){
            int lowest = nums[i-k+1];
            int highest = nums[i];

            minDiff = Math.min(minDiff , highest-lowest);
        }

        return minDiff ;
    }
}

/// question Link -> https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/