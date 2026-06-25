

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         // [1,2,1,0,4,2,6], k = 3
         //Output: [2,2,4,4,6]

        java.util.ArrayList<Integer> res = new java.util.ArrayList<Integer>();
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
             pq.offer(nums[i]);
        }
        
        res.add(pq.peek());

        int last = 0;

        for (int i = k; i < nums.length; i++) {
             pq.remove(nums[last]);
             pq.add(nums[i]);
             res.add(pq.peek());
             last++;
        }
       
       return res.stream().mapToInt(Integer::intValue).toArray();

        
    }
}
