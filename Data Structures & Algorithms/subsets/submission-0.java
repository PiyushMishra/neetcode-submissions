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

       if(i >= nums.length) {
         return;
       }

       res.add(nums[i]);
       global.add(new ArrayList<Integer>(res));
       subsetsH(nums, i+1, global, res);
       res.remove(res.size() -1);
       subsetsH(nums, i+1, global, res);

       }
}

