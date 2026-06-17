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

/**
 Do not return anything, modify head in-place instead.
 */
function reorderList(head: ListNode | null): void {
    // stack push n
    let stack = new Array<ListNode>();
    let node: ListNode = head;
    while (node) {
        stack.push(node);
        node = node.next;
    }
    let start = 0, end = stack.length - 1;
    let pre: ListNode = new ListNode(0);
    // head node.next point to the stack.pop 
    // until node === stack.pop
    while (start <= end) {

        node = stack[start++] || null;
        node.next = stack[end--] || null;
        pre.next = node;
        pre = node.next;
    }
    if (pre) pre.next = null;
};