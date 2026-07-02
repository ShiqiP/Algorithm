class Node {
    int val;
    Node pre;
    Node next;

    public Node(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

class MyCircularQueue {
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);

        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public boolean enQueue(int value) {
        if (this.size < this.capacity) {

            Node node = new Node(value);
            Node pre = this.tail.pre;

            pre.next = node;

            node.pre = pre;
            node.next = this.tail;

            this.tail.pre = node;

            this.size += 1;

            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (this.size > 0) {
            this.head = this.head.next;
            this.head.pre = null;
            this.size -= 1;

            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        return this.size == 0 ? -1 : this.head.next.val;
    }

    public int Rear() {
        return this.size == 0 ? -1 : this.tail.pre.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */