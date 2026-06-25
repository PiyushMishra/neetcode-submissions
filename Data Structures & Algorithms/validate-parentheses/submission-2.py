class Solution:
    def isValid(self, s: str) -> bool:
        
        bracket_mapping = {'(':')', '{':'}', '[':']'}
        st = []

        for ch in s:
            if ch in ['(', '{', '[']:
                st.append(ch)
            else:
                if len(st) == 0:
                    return False
                if bracket_mapping[st.pop()] != ch:
                    return False     

        if len(st) != 0:
            return False

        return True    