class Solution {
    public int findMin(int[] nums) {
        return findMinH(nums, 0, nums.length - 1);
    }

    public int findMinH(int[] arr, int l, int r) {
        // Base case: only one element left
        if (l == r) return arr[l];

        int mid = l + (r - l) / 2;

        // If mid element is greater than the rightmost, min must be in right half
        if (arr[mid] > arr[r]) {
            return findMinH(arr, mid + 1, r);
        } else {
            // Else, min is in left half including mid
            return findMinH(arr, l, mid);
        }
    }
}
