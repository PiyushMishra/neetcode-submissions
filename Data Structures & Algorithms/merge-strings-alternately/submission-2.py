class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = []
        l: int = 0
        r: int = 0

        while l < len(word1) and r < len(word2):
            res.append(word1[l])
            l += 1
            res.append(word2[r])
            r += 1

        if l < len(word1):
            while l < len(word1):
                res.append(word1[l])
                l +=1

        if r < len(word2):
            while r < len(word2):
                res.append(word2[r])
                r +=1            

        return "".join(map(str,res))        