class LRUCache {

    LRUCacheH<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LRUCacheH<>(capacity);
    }
    
    public int get(int key) {
        if(cache.get(key) == null) {
            return -1;
        }
        return cache.get(key).intValue();
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}



class LRUCacheH<K, V> {

    static class Node<K, V> {
         
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    int capacity;
    HashMap<K, Node<K, V>> hmap;
    Node<K, V> head;
    Node<K, V> tail;

    LRUCacheH(int capacity) {
        this.capacity = capacity;
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
        this.hmap = new HashMap<>(capacity);
    }

    void removeNode(Node<K, V> node) {

        Node next = node.next;
        Node prev = node.prev;
        
        prev.next = next;
        next.prev = prev;

    }

    void insertAtEnd(Node<K, V> node) {
        
        Node tailPrev = tail.prev;
        
        tailPrev.next = node;
        node.prev = tailPrev;

        tail.prev = node;
        node.next = tail;
    }


    public void put(K key, V value) {
        Node<K, V> node = hmap.get(key);

        if(node != null) {
            node.value = value;
            removeNode(node);
            insertAtEnd(node);
            return;
        }

        Node<K, V> newNode = new Node<>(key, value);
        hmap.put(key, newNode);
        insertAtEnd(newNode);

        if(hmap.size() > capacity) {
            Node<K, V> nodeToRemove = head.next;
            hmap.remove(nodeToRemove.key);
            removeNode(nodeToRemove);
        }

    }

    public V get(K key) {
          Node<K, V> node = hmap.get(key);

          if(node == null) {
            return null;
          }

          removeNode(node);
          insertAtEnd(node);

          return node.value;
     }
}