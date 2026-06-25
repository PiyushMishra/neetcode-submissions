class Solution {
    public List<List<Integer>> subsets(int[] nums) {

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
            res.add(nums[j]);
            global.add(new ArrayList<Integer>(res));
            subsetsH(nums, j + 1, global, res);
            res.remove(res.size() - 1);
        }
    }
}
