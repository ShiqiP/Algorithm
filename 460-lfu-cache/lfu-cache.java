class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        Node pre;
        Node next;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.pre = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int length;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1, Integer.MIN_VALUE);
        this.tail = new Node(-1, 0, Integer.MAX_VALUE);

        this.head.next = this.tail;
        this.tail.pre = this.head;

        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int key) {
        // * exist 
        // * get node to get value
        // *update frequency
        // reposition the node
        // not 
        // return -1;
        Node node = map.get(key);
        if (node != null) {
            node.freq += 1;
            Node next = node.next;
            remove(node);
            insertNode(node, next);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // exist
        // * get node, 
        // * update frequency
        // * remove node
        // * insert node in ascending order
        // * check length
        // * exceed length, remove the least freq node

        // * new Node, put to map 
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            node.freq += 1;
            Node next = node.next;
            remove(node);
            insertNode(node, next);
            return;
        }

        if (this.length >= this.capacity) {
            map.remove(this.head.next.key);
            remove(this.head.next);
            
            this.length--;
        }
        // 
        Node newNode = new Node(key, value, 1);
        map.put(key, newNode);
        insertNode(newNode, this.head.next);
        this.length++;
    }

    public void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    //  1 2  3 /5 tail    4
    public void insertNode(Node node, Node start) {
        Node cur = start;
        System.out.println(cur.value);
        while (cur != tail && cur.freq <= node.freq) {
            cur = cur.next;
        }
        Node pre = cur.pre;

        pre.next = node;
        node.pre = pre;

        cur.pre = node;
        node.next = cur;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */