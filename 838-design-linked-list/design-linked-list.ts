
class MyLinkedList {

    head: ListNode;
    rear: ListNode;
    length: number;

    constructor() {
        this.head = new ListNode(-1);
        this.length = 0;
    }

    get(index: number): number {

        if (index < 0 || index > this.length - 1) return -1;

        const node = this.getNodeByIndex(index);

        return node.val;
    }

    addAtHead(val: number): void {
        this.addAtIndex(0, val);
    }

    addAtTail(val: number): void {
        this.addAtIndex(this.length, val);
    }

    addAtIndex(index: number, val: number): void {

        // invalid index
        if (index > this.length || index < 0) return;

        // add to empty list, update head and 
        if (this.length === 0) { this.addToEmptyList(val); return; }

        const preNode = this.getNodeByIndex(index - 1);

        const next: ListNode = preNode.next;
        const newNode: ListNode = new ListNode(val);

        preNode.next = newNode;
        newNode.next = next;

        this.increaseLength()
    }

    deleteAtIndex(index: number): void {
        if (index < 0 || index > this.length - 1) return;

        const preNode = this.getNodeByIndex(index - 1);
        const deleteNode = preNode.next;
        const next = deleteNode.next;

        preNode.next = next;

        this.decreaseLength()
    }
    getNodeByIndex(index: number): ListNode {
        let i: number = -1;
        let preNode = this.head;

        while (i < index) {
            preNode = preNode.next;
            i++;
        }

        return preNode;
    }
    addToEmptyList(val: number): void {
        const newNode: ListNode = new ListNode(val);

        this.head.next = newNode;
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