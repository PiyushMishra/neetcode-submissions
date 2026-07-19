impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {

        let  (mut start, mut end) = (0 as i32, (nums.len() -1) as i32);

        while start <= end {
            
            let mid = (start + end)/2;
            
            if nums[mid as usize] == target {
                return mid
            }
            else if nums[mid as usize] < target {
                start = mid + 1
            }
            else {
                end = mid -1
            }

        }
        
        return -1;

    }
}
