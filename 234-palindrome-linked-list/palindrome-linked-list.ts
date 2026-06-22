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

function isPalindrome(head: ListNode | null): boolean {
    let stack: Array<number> = [];
    let node = head;

    while (node) {
        stack.push(node.val);
        node = node.next;
    }

    const mid = Math.floor(stack.length / 2);
    const length = stack.length;

    for (let i = 0; i < mid; i++) {
        if (stack[i] !== stack[length - 1 - i]) return false;
    }
    return true;
};