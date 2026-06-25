class Solution {
    public int lastStoneWeight(int[] stones) {

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());

        for(int i =0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        
        while(pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a < b) pq.offer(b -a); else pq.offer(a -b);

        }
        
        return pq.peek();
    }
}
