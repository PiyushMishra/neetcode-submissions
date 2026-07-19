impl Solution {

    pub fn is_anagram(s: String, t: String) -> bool {

        if s.len() != t.len() {
            return false
        }

        let mut freq = [0; 26];
        let s_bytes = s.as_bytes();
        let t_bytes = t.as_bytes();
        
        for i in 0..s.len() {
            freq[(s_bytes[i]  - b'a') as usize] += 1;
            freq[(t_bytes[i]  - b'a') as usize] -= 1;
        }

        for value in freq {
            if value != 0 {
                return false;
            }
        }

        return true

    }
}
