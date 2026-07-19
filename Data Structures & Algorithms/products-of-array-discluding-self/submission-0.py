class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
    
        n = len(nums)

        # Prefix products
        prefix = [1]
        for num in nums:
            prefix.append(prefix[-1] * num)

        # Suffix products
        suffix = [1] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]

        # Build answer
        answer = []
        for i in range(n):
            answer.append(prefix[i] * suffix[i + 1])

        return answer

        