public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> hmap;
    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.hmap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hmap.containsKey(key)) {
            Node node = hmap.get(key);
            remove(node);
            insertToEnd(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // key exists

        if (hmap.containsKey(key)) {
            Node node = hmap.get(key);
            node.value = value;
            remove(node);
            insertToEnd(node);
            return;
        }

        Node node = new Node(key, value);
        hmap.put(key, node);
        insertToEnd(node);

        if (hmap.size() > capacity) {
            Node headNext = head.next;
            hmap.remove(headNext.key);
            remove(headNext);
        }
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void insertToEnd(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
}
