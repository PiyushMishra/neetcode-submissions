class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        first_string_freq = self.count_frequency(s)
        second_string_freq = self.count_frequency(t)

        return first_string_freq == second_string_freq

        
    def count_frequency(self, s: str):
        hash_map = {}
        for ch in s:
            if ch in hash_map:
                hash_map[ch] += 1
            else:
                hash_map[ch] = 1
        return hash_map   