class Solution {
    public int search(int[] nums, int target) {
         return searchH(nums, target, 0, nums.length - 1);
    }

    public int searchH(int[] nums, int target, int l, int r) {

        if(l > r) return -1;

        int mid = (r +l)/2;

        if(nums[mid] == target) {
          return mid;
        }
        else if(nums[mid] < target) {
            return searchH(nums, target, mid +1, r);
        } else {
            return searchH(nums, target, l, mid -1);
        }
        
    }
}
