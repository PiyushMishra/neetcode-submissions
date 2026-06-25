class KthLargest {

    int k;
    int [] nums;

    java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();


    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
        for(Integer i: nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
