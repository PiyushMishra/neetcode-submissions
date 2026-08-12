// House Robber 1
class Solution {
    public int rob(int[] nums) {

        int houses = nums.length;
        int[] dp = new int[houses];

        // we have two choice, rob it or not.
        dp[0] = nums[0];
        
        if(houses > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length-1];
    }
}
