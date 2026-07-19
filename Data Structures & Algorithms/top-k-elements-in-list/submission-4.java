class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for(int num: nums) {
           hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<Pair>((a, b) -> 
            Integer.compare(a.value() , b.value())
        );

        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            
            heap.offer(new Pair(entry.getKey(), entry.getValue()));
            
            if (heap.size() > k) {
                heap.poll();
            } 
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = heap.poll().key();
        }

        return res;
    }
}

record Pair(int key, int value) {};
