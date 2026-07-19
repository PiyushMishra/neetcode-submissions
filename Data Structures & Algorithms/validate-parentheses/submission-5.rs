use std::collections::HashMap;

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut hash_map = HashMap::<char, char>::new();

        hash_map.insert('{', '}');
        hash_map.insert('[', ']');
        hash_map.insert('(', ')');

        let mut stack = Vec::<char>::new();

        for ch in s.chars() {
            if hash_map.contains_key(&ch) {
                // Opening bracket
                stack.push(ch);
            } else {
                // Closing bracket
                if stack.is_empty() {
                    return false;
                }

                if hash_map.get(&stack.pop().unwrap()) != Some(&ch) {
                    return false;
                }
            }
        }

        stack.is_empty()
    }
}