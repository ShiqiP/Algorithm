class Node {
    String url;
    Node next;
    Node pre;

    public Node(String url) {
        this.url = url;
        this.next = null;
        this.pre = null;
    }
}

class BrowserHistory {
    Node head;
    Node current;
    // Node tail;

    public BrowserHistory(String homepage) {
        this.head = new Node("");
        // this.tail = new Node("");
        Node newNode = new Node(homepage);

        this.head.next = newNode;
        newNode.pre = this.head;

        this.current = newNode;
    }

    public void visit(String url) {
        Node node = this.head.next;
        Node pre = this.head;
        while (node != null) {
            if (node.url == url) {
                break;
            }
            node = node.next;
            pre = pre.next;
        }

        // found the node
        if (node != null) {
            // clear up all the forward histroy
            node.next = null;
            this.current = node;
        } else {
            // not found
            Node newNode = new Node(url);
            this.current.next = newNode;
            newNode.pre = this.current;
            this.current = newNode;
        }
    }

    public String back(int steps) {
        Node node = this.current;
        // 1 2 3 /4 5 6
        while (steps > 0 && node.pre != this.head) {
            node = node.pre;
            steps--;
        }
        this.current = node;
        return node.url;
    }

    public String forward(int steps) {
        Node node = this.current;
        // 1 2 3 /4 5 6
        while (steps > 0 && node.next != null) {
            node = node.next;
            steps--;
        }
        this.current = node;
        return node.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */