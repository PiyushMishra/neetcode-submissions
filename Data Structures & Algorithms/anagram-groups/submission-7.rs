use std::collections::HashMap;

impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {

        let result: Vec<Vec<String>> = vec![];

        let mut hash_map: HashMap<String, Vec<String>> = HashMap::new();

        for s in strs {
            let key = Self::freq(s.clone());
            let entry = hash_map.entry(key).or_insert(Vec::new());
            entry.push(s);
        }

        hash_map.into_values().collect()

    }

    pub fn freq(s: String) -> String {
        
        let mut freq_arr = [0; 26];

        let s_bytes = s.as_bytes();

        for i in 0..s_bytes.len() {
            freq_arr[(s_bytes[i] - b'a') as usize] += 1;
        } 

        freq_arr.iter().map(|x| x.to_string()).collect::<Vec<_>>().join("#")         
    }
}
