class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t:
            return ""

        # Step 1: count frequency of characters in t
        target = {}
        for ch in t:
            target[ch] = target.get(ch, 0) + 1

        window = {}  # current window frequency

        have = 0                  # how many chars matched correctly
        need = len(target)        # total unique chars needed

        res = ""
        res_len = float("inf")

        l = 0

        # Step 2: expand window using right pointer
        for r in range(len(s)):
            ch = s[r]
            window[ch] = window.get(ch, 0) + 1

            # if this char meets required frequency
            if ch in target and window[ch] == target[ch]:
                have += 1

            # Step 3: shrink window when valid
            while have == need:
                # update result if smaller window found
                if (r - l + 1) < res_len:
                    res = s[l:r+1]
                    res_len = r - l + 1

                # remove left character
                left_char = s[l]
                window[left_char] -= 1

                # if removing breaks validity
                if left_char in target and window[left_char] < target[left_char]:
                    have -= 1

                l += 1  # move left pointer

        return res