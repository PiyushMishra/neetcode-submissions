class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = []
        
        l = min(len(word1), len(word2))

        for i in range(0, l):
            res.append(word1[i])
            res.append(word2[i])
        
        res.extend(word1[l:])
        res.extend(word2[l:])

        return "".join(map(str,res))        