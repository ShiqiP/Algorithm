class AllOne {
    class Node {
        int freq;
        Set<String> keys = new HashSet<>();
        Node pre;
        Node next;

        public Node(int freq) {
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> freqMap;
    private Node head;
    private Node tail;

    public AllOne() {
        freqMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        // int freq = 1 + freqMap.getOrDefault(key, 0);
        // freqMap.put(key, freq);
        if (freqMap.containsKey(key)) {
            Node freqNode = freqMap.get(key);
            Node next = freqNode.next;
            Node pre = freqNode.pre;
            int freq = freqNode.freq;
            freqNode.keys.remove(key);

            if (next == tail || next.freq != freq + 1) {
                Node newNode = new Node(freq + 1);
                newNode.keys.add(key);
                newNode.pre = freqNode;
                newNode.next = next;

                freqNode.next = newNode;
                next.pre = newNode;

                freqMap.put(key, newNode);

            } else {
                next.keys.add(key);
                freqMap.put(key, next);
            }
            if (freqNode.keys.isEmpty()) {
                removeNode(freqNode);
            }
        } else {
            Node node = head.next;
            if (node.freq != 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.pre = head;
                newNode.next = node;

                head.next = newNode;
                node.pre = newNode;

                freqMap.put(key, newNode);
            } else {
                node.keys.add(key);
                freqMap.put(key, node);
            }
        }

    }

    public void dec(String key) {
        Node freqNode = freqMap.get(key);
        Node pre = freqNode.pre;
        Node next = freqNode.next;
        int freq = freqNode.freq;
        freqNode.keys.remove(key);

        if (freq - 1 == 0) {
            freqMap.remove(key);
        } else {
            if (pre.freq != freq - 1) {
                Node newNode = new Node(freq - 1);
                newNode.keys.add(key);
                newNode.pre = pre;
                newNode.next = freqNode;

                pre.next = newNode;
                freqNode.pre = newNode;

                freqMap.put(key, newNode);
            } else {
                pre.keys.add(key);
                freqMap.put(key, pre);
            }
        }
        if (freqNode.keys.isEmpty()) {
            removeNode(freqNode);
        }
    }

    public String getMaxKey() {
        if (tail.pre == head) {
            return "";
        }
        return tail.pre.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.pre;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.pre = prevNode;
    }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */