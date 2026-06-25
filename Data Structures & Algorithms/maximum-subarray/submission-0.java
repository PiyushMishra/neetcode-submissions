class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int r = 0;

        int sum = 0;

        while(r < nums.length) {
           sum = sum + nums[r];
           if(sum > maxSum) {
             maxSum = sum;
           } 

           if(sum < 0) {
             sum = 0;
           }
           r++; 

        }
        
        return maxSum;
    }
}


