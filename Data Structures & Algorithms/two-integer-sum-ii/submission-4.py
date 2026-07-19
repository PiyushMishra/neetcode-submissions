class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        numbers.sort()
        res = []
        l: int = 0
        r: int = len(numbers) - 1    
        
        while l < r:
            sum: int = numbers[l] + numbers[r]
            if sum == target:
                res = [l+1, r+1]
                l += 1
                r -= 1
            elif sum < target:
                l += 1
            else:
                r -= 1

        res.sort()     
        return res         



             
        