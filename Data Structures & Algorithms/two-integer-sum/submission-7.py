class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map: Dict[int, int] = {}
        res: List[int] = []
        for i, num in enumerate(nums):
            target_remaining: int = target - num
            if target_remaining in hash_map:
                res.append(i)
                res.append(hash_map[target_remaining])
                break;
            else:
                hash_map[num] = i
        res.sort()
        return res
