class LRUCache {

    public class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.prev = null;
            this.next = null;
        }
    }

    public int capacity;
    public Node left;
    public Node right;
    public HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.cache = new HashMap<>();
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node val = cache.get(key);
            remove(val);
            insert(val);
            return val.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        } 
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if(cache.size() > this.capacity) {
            Node lru = this.left.next;
            remove(cache.get(lru.key));
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
