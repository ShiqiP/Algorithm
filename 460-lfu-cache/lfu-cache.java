import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int freq;
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head; // sentinel: head.next = lowest freq / least-recently-used real node
    private Node tail; // sentinel
    private int capacity;
    private int length;

    public LFUCache(int capacity) {
        this.head = new Node(-1, -1, Integer.MIN_VALUE);
        this.tail = new Node(-1, -1, Integer.MAX_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        node.freq += 1;
        reposition(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return; // cache can never hold anything
        }

        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            node.freq += 1;
            reposition(node);
            return;
        }

        if (length >= capacity) {
            evictLFU();
        }

        Node newNode = new Node(key, value, 1);
        map.put(key, newNode);
        length++;
        // freq is 1, the lowest possible, so it belongs somewhere in [head.next, ...)
        insertInOrder(newNode, head.next);
    }

    // Removes `node` from its current spot, then re-inserts it so the list stays
    // sorted ascending by freq (head -> tail), placed after every node with
    // freq <= node.freq (i.e., last / most-recently-used within its own freq tier).
    private void reposition(Node node) {
        Node searchStart = node.next; // valid: everything up to and including node's
                                       // old spot already satisfies freq <= old freq <= new freq
        unlink(node);
        insertInOrder(node, searchStart);
    }

    private void insertInOrder(Node node, Node searchStart) {
        Node curr = searchStart;
        while (curr != tail && curr.freq <= node.freq) {
            curr = curr.next;
        }
        Node before = curr.prev;
        before.next = node;
        node.prev = before;
        node.next = curr;
        curr.prev = node;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void evictLFU() {
        Node victim = head.next; // safe: length >= capacity > 0 guarantees a real node exists
        unlink(victim);
        map.remove(victim.key);
        length--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */