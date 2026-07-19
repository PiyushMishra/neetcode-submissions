class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail; 

    HashMap<Integer, Node> hmap = new HashMap<Integer, Node>(); 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)) {
           return -1;
        }
        Node node = hmap.get(key);
        remove(node);
        insertAtEnd(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        // Key already exists
        if (hmap.containsKey(key)) {

            Node node = hmap.get(key);

            node.value = value;

            remove(node);
            insertAtEnd(node);

            return;
        }

        // New key
        Node node = new Node(key, value);

        hmap.put(key, node);
        insertAtEnd(node);

        // Remove LRU if capacity exceeded
        if (hmap.size() > capacity) {

            Node lru = head.next;

            remove(lru);
            hmap.remove(lru.key);
        }
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void insertAtEnd(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
    
}
