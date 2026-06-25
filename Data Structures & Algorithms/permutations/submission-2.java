// import java.util.ArrayList;
// import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> global = new ArrayList<>();
        permuteH(nums, 0, global); 
        return global;
    }

    public void permuteH(
        int[] nums, 
        int i, 
        List<List<Integer>> global
    ) { 
        if (i == nums.length) {
            global.add(createDuplicateList(nums));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteH(nums, i + 1, global);
            swap(nums, i, j); 
        }
    }

    void swap(int[] nums, int i, int j) {
        int a = nums[j];
        nums[j] = nums[i];
        nums[i] = a;
    }

    ArrayList<Integer> createDuplicateList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
