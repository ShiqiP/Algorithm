class LRUCache {

    // linklist get key 
    // node points to the recently used node 
    // head   [head, node] <= capacity

    // When get and put. remove old node, add node to the end
    // when size > capacity remove node from head;
    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.pre = null;
        }
    }

    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;

        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
            add(oldNode);
            return oldNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }
        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            ListNode toDeleteNode = head.next;
            remove(toDeleteNode);
            map.remove(toDeleteNode.key);
        }
    }

    public void add(ListNode node) {
        ListNode pretail = this.tail.pre;
        pretail.next = node;

        node.pre = pretail;
        node.next = this.tail;

        this.tail.pre = node;
    }

    public void remove(ListNode node) {
        ListNode preNode = node.pre;
        ListNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */