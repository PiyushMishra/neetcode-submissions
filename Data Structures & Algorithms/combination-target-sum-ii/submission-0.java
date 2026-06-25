class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> global = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2H(global, new ArrayList<Integer>(), candidates, target, 0, 0);
        return global;
    }

    public void combinationSum2H(
        List<List<Integer>> global,
        List<Integer> res,
        int[] nums,  
        int target, 
        int sum, 
        int index
    ) {
        
        if(sum == target) {
            global.add(new ArrayList<>(res));
            return;
        }
       
        for(int j = index; j < nums.length; j++) {
            if (j > index && nums[j] == nums[j - 1]) continue;

            if(sum + nums[j] > target) {
                continue;
            }
            res.add(nums[j]);
            combinationSum2H(global, res, nums, target, sum + nums[j], j+1);
            res.remove(res.size() - 1);
        }
    }
}
