class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);  // every element is an LIS of at least 1

        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }

        return maxLen;
    }
}
