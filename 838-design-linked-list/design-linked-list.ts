
class MyLinkedList {

    head: ListNode;
    rear: ListNode;
    length: number;

    constructor() {
        this.head = new ListNode(-1);
        this.rear = null;
        this.length = 0;
    }

    get(index: number): number {

        if (index < 0 || index > this.length - 1) return -1;

        let i: number = 0;
        let node: ListNode = this.head.next;
        // console.log("--------");
        // console.log("index" + index)
        // console.log("this.length" + this.length)
        while (i < index) {
            // console.log(node.val);
            node = node.next;
            i++;
        }

        return node?.val;
    }

    addAtHead(val: number): void {
        const newNode: ListNode = new ListNode(val);

        if (this.length === 0) {
            this.addToEmptyList(newNode);
            return;
        }

        const next: ListNode = this.head.next;

        this.head.next = newNode;
        newNode.next = next;
        this.increaseLength()
    }

    addAtTail(val: number): void {
        const newNode: ListNode = new ListNode(val);

        if (this.length === 0) {
            this.addToEmptyList(newNode);
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;

        this.increaseLength()
    }

    addAtIndex(index: number, val: number): void {

        if (index > this.length || index < 0) return;
        if (index === this.length) { this.addAtTail(val); return; }

        const preNode = this.findPreNode(index);

        const next: ListNode = preNode.next;
        const newNode: ListNode = new ListNode(val);

        preNode.next = newNode;
        newNode.next = next;

        this.increaseLength()
    }

    deleteAtIndex(index: number): void {
        if (index < 0 || index > this.length - 1) return;

        const preNode = this.findPreNode(index);
        const deleteNode = preNode.next;
        const next = deleteNode.next;

        preNode.next = next;
        this.decreaseLength()

        if (next === null) {
            this.rear = preNode;
        }

    }
    findPreNode(index: number): ListNode {
        let i: number = 0;
        let preNode = this.head;
        while (i < index) {
            preNode = preNode.next;
            i++;
        }
        return preNode;
    }
    addToEmptyList(newNode: ListNode): void {
        this.head.next = newNode;
        this.rear = newNode;
        this.increaseLength()
    }
    increaseLength() {
        this.length++;
    }
    decreaseLength() {
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */