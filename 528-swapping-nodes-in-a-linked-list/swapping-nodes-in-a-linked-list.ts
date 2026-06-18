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


    while (node) {
        stack.push(node);
        node = node.next;
    }

    node1 = stack[k - 1];
    node2 = stack[stack.length - k];

    [node1.val, node2.val] = [node2.val, node1.val];

    return head;
};