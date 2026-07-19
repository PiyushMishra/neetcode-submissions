impl Solution {
    pub fn has_duplicate(mut nums: Vec<i32>) -> bool {
        if nums.len() == 0 {
            return false;
        }
        nums.sort();
        for i in 0..nums.len() -1 {
            if nums[i] == nums[i + 1] {
                return true;
            }
        }
        return false;
    }
}
