use std::collections::HashMap;
use std::cmp::max;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut last_seen = HashMap::<char, usize>::new();

        let mut left = 0;
        let mut max_so_far = 0;

        for (right, ch) in s.chars().enumerate() {
            if let Some(&previous_index) = last_seen.get(&ch) {
                left = max(left, previous_index + 1);
            }

            last_seen.insert(ch, right);

            max_so_far = max(max_so_far, right - left + 1);
        }

        max_so_far as i32
    }
}