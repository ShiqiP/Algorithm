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

function hasCycle(head: ListNode | null): boolean {
    // fast node, slow node
    let fast: ListNode = head;
    let slow: ListNode = head;
    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast && fast === slow) {
            return true;
        }

    }
    return false;
};