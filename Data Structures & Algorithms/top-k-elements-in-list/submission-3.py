import heapq as pq
from collections import defaultdict
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)

        # Count frequency
        for num in nums:
            freq[num] += 1

        # Min heap (size k)
        heap = []

        for key, value in freq.items():
            pq.heappush(heap, (value, key))

            if len(heap) > k:
                pq.heappop(heap)

        # Extract elements from heap
        return [key for value, key in heap]