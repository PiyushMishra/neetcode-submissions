class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # nums.sort()
        
        # l = 0
        # r = len(nums) -1

        # res = []

        # while l < r:
        #     if nums[l] + nums[r] == target:
        #         res = [l, r]
        #         l += 1
        #         r -= 1
        #     elif nums[l] + nums[r] < target:
        #         l += 1
        #     else:
        #         r -= 1    
        # return res                      
        seen = {}
        for (i, num) in enumerate(nums):
            complement = target - num
            if complement in seen:
               return [seen[complement], i]
            else:
                seen[num] = i    
        