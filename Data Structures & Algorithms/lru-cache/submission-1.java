class LRUCache {

    int capacity = 0;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    Queue<Integer> queue = new LinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)) {
            int value = hmap.get(key);
            queue.remove(key);
            queue.offer(key);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)) {
            hmap.put(key, value);
            queue.remove(key);
            queue.offer(key);
        } else {
            if(hmap.size() >= capacity) {
                int oldestKey = queue.poll();
                hmap.remove(oldestKey);
            }
            hmap.put(key, value);
            queue.offer(key);
        }
    }
}
