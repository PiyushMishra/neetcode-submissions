// import java.util.ArrayList;
// import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    
        List<List<Integer>> global = new ArrayList<>();
        combinationSumH(
            nums, 
            global, 
            new ArrayList<Integer>(), 
            target,
            0, 
            0
        );
        return global;
        
    }
    
    public void combinationSumH(
        int[] nums,
        List<List<Integer>> global,
        List<Integer> res,
        int target, 
        int sum, 
        int index) {
        
        if(sum == target) {
            global.add(new ArrayList<>(res));
            return;
        }
        for(int j = index; j < nums.length; j++) {
            if(sum + nums[j] > target) {
                continue;
            }
            res.add(nums[j]);
            combinationSumH(nums, global, res, target, nums[j] + sum, j);
            res.remove(res.size() - 1);
        }
    }
}
