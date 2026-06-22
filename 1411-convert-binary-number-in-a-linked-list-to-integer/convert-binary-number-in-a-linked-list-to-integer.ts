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

function getDecimalValue(head: ListNode | null): number {

    let length = 0;
    let node = head;
    while (node) {
        node = node.next;
        length++;
    }

    function solve(head: ListNode | null, length: number): number {
        if (head.next === null) {
            return head.val;
        }

        const next = solve(head.next, length - 1);
        const current = head.val * Math.pow(2, length - 1);
        const sum = next + current;

        return sum;
    }

    const ans = solve(head, length)
    return ans;
};