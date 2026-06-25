import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub(r"[^\w]", "", s.lower())
        i: int = 0;
        j: int = len(s) -1

        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
                  