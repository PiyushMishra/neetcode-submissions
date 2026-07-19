class Solution:
    def isValid(self, s: str) -> bool:
        bracket_map = {'}':'{', ']':'[', ')':'('}
        stack = []
        for c in s:
            if c in bracket_map.values():
                stack.append(c)
            else:
                if not stack:
                    return False
                else:
                    if not bracket_map[c] == stack.pop():
                        return False 
        
        return not stack