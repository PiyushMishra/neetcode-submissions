import heapq as pq

class KthLargest:
    
    def __init__(self, k: int, nums: List[int]):
        self.heap = []
        self.nums = nums
        self.k = k
        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        pq.heappush(self.heap, val)
        if len(self.heap) > self.k:
            pq.heappop(self.heap)
        return self.heap[0]     

        
