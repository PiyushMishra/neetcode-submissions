class Solution {
    public int search(int[] nums, int target) {

        return searchH(nums, target, 0, nums.length - 1);

    }

    public int searchH(int[] nums, int target, int l, int r) {
        if( l > r) return -1;

        int mid = l + (r - l) / 2;


        if(nums[mid] == target) return mid;

        if(nums[l] <= nums[mid]) {
             if(target >= nums[l] && target < nums[mid]) {
                return searchH(nums, target, l, mid-1);
             }
             else {
                return searchH(nums, target, mid+1, r);
             }
        } else {

            if(target > nums[mid] && target <= nums[r]) {
                return searchH(nums, target, mid+1, r);
             }
             else {
                return searchH(nums, target, l, mid-1);
             }

        }  
    }
}