class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        i = 0
        r = 0

        max_window_length = 0

        hash_map = {} 

        while r < len(s):
            if s[r] in hash_map:
                last_index = hash_map[s[r]]
                i = max(last_index + 1, i)
            hash_map[s[r]] = r
            max_window_length = max(r - i + 1, max_window_length)
            r += 1

        return max_window_length


        