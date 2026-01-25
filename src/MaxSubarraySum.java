public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4 ;

        System.out.println(maxSubArray(arr, k));
    }
    public static int maxSubArray(int[] arr, int k) {
        int n = arr.length ;
        int sum = 0 ;
        for(int i = 0 ; i<k; i++){
            sum += arr[i];
        }

        int maxSum = sum ;
        for(int i = k ; i<n; i++){
            sum = (sum+arr[i])-arr[i-k];
            maxSum = Math.max(maxSum , sum);
        }

        return maxSum ;
    }
}
