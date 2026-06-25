from typing import Set

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # hash_set: Set[int] = set()
        # for num in nums:
        #     if num in hash_set:
        #         return True;
        #     hash_set.add(num)
        # return False    
        nums.sort()
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        return False         