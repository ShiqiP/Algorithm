class Node {
    int value;
    Node next;
    Node pre;
    int count;

    public Node(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class MaxStack {

    private Node head;
    private Node tail;
    private int count;
    private PriorityQueue<Node> maxHeap;

    // 5 1 
    // 5 5 1 5 1 5 
    public MaxStack() {
        this.head = new Node(-1, 0);
        this.tail = new Node(-1, 0);
        this.maxHeap = new PriorityQueue<>((n1, n2) -> {
            return (n2.value - n1.value == 0) ? (n2.count - n1.count) : (n2.value - n1.value);
        });

        this.head.next = tail;
        this.tail.pre = head;
        this.count = 0;
    }

    public void push(int x) {
        this.count++;
        Node newNode = new Node(x, this.count);
        Node preTail = this.tail.pre;

        preTail.next = newNode;
        newNode.pre = preTail;
        newNode.next = this.tail;
        this.tail.pre = newNode;

        // max
        this.maxHeap.add(newNode);
    }

    public int pop() {
        // if(this.size == 0) return null;

        Node toPopNode = this.tail.pre;
        Node prePopNode = toPopNode.pre;

        prePopNode.next = this.tail;
        this.tail.pre = prePopNode;

        this.maxHeap.remove(toPopNode);
        this.count--;
        // 5 1 5
        return toPopNode.value;
    }

    public int top() {
        Node topNode = this.tail.pre;
        return topNode.value;
    }

    public int peekMax() {
        return this.maxHeap.peek().value;
    }

    public int popMax() {
        Node node = this.maxHeap.poll();
        System.out.println(node.value);
        Node pre = node.pre;
        System.out.print(pre.value);
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        this.count--;
        return node.value;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */