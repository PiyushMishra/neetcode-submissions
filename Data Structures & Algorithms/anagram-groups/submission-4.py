from collections import defaultdict

class Solution:
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        res: defaultdict = defaultdict(list)

        for s in strs: 
            res[self.get_freq(s)].append(s)

        return list(res.values())    

    def get_freq(self, s: str) -> str:
        
        freq = [0]*26
       
        for i in range(0 , len(s)):
            freq[ord(s[i]) - ord('a')] += 1
        
        return "-".join(map(str, freq))