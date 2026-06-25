// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

class LRUCache {

    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    
    Queue<Integer> queue  = new LinkedList();

    int capacity = 0;
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
    
    // let me write the put method, please dont suggest any changes
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
