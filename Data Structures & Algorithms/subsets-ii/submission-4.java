class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Step 1: sort to group duplicates
        List<List<Integer>> global = new ArrayList<>();
        global.add(new ArrayList<Integer>());
        subsetsH(nums, 0, global, new ArrayList<Integer>());
        return global;
    }

    public void subsetsH(
        int[] nums, 
        int i, 
        List<List<Integer>> global, 
        List<Integer> res
    ) {
        for (int j = i; j < nums.length; j++) {
            // Step 2: skip duplicates
            if (j > i && nums[j] == nums[j - 1]) continue;

            res.add(nums[j]);
            global.add(new ArrayList<>(res));
            subsetsH(nums, j + 1, global, res);
            res.remove(res.size() - 1); // backtrack
        }
    }
}
