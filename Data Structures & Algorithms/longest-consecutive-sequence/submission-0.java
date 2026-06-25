
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // Step 1: load set
        for (int n : nums) {
            set.add(n);
        }

        int longest = 0;

        // Step 2: find sequence starts
        for (int n : set) {
            // only start counting if n is the beginning
            if (!set.contains(n - 1)) {

                int current = n;
                int length = 1;

                // Step 3: count upward
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
