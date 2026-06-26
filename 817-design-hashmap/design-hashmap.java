class MyHashMap {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
       Node head;
        Node tail;
    public MyHashMap() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public void put(int key, int value) {
        Node oldNode = getNode(key);
        if(oldNode != null){
            oldNode.value = value;
            return;
        }
        Node node = new Node(key, value);
        
        Node preTail = this.tail.pre;
        preTail.next = node;

        node.pre = preTail;
        node.next = this.tail;
        
        this.tail.pre = node;
    }

    public Node getNode(int key){
        Node node = this.head.next;
        while(node != null){
            if(node.key == key) return node;
            node = node.next;
        }
        return null;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        if(node != null) return node.value;
        return -1;
    }
    
    public void remove(int key) {
        Node toDeletNode = getNode(key);
        
        if(toDeletNode == null) return;
        
        Node preNode = toDeletNode.pre;
        Node nextNode = toDeletNode.next;
        
        preNode.next = nextNode;
        nextNode.pre = preNode;

        // nextNode is never null, there is tail at the end;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */