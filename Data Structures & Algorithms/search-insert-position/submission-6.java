class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int res = nums.length;
        int j = nums.length-1;
        while(i <= j) {
           int mid = (i + j) /2;
           if(nums[mid]== target){
            return mid;
           } else if(nums[mid] < target){
              i = mid + 1;
           } else {
              res = mid;  
              j = mid -1;
           }
        }

        return res;
        
    }
}