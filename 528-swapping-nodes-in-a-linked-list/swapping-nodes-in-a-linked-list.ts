/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function swapNodes(head: ListNode | null, k: number): ListNode | null {
    let stack: Array<ListNode> = [];
    let node = head;
    let node1 = null, node2 = null;
    let count = 1;
    while (node) {
        stack.push(node);
        if (count === k) {
            node1 = node;
        }
        node = node.next;
        count++;
    }

    count = k - 1;
    while (count > 0) {
        stack.pop();
        count--;
    }

    node2 = stack[stack.length - 1];

    let temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;

    return head;
};