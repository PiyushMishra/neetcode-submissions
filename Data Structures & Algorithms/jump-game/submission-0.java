class Solution {
    public boolean canJump(int[] nums) {

       int goal = nums.length -1;

       int r = goal -1;

       while(r >= 0) {
           if(nums[r] >= goal - r) {
             goal = r;
           }
           r--;       
       }

       return goal == 0;
        
    }
}
