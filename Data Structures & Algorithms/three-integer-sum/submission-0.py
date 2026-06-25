class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for index in range(len(nums)):
            
            if index > 0 and nums[index] == nums[index -1]:
                continue

            target = -nums[index]
            l = index + 1
            r = len(nums) -1

            while l < r:
                if nums[l] + nums[r] == target:
                    res.append([nums[index], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    # ✅ skip duplicates for l
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1

                    # ✅ skip duplicates for r
                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1
    
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1

        return res     

        