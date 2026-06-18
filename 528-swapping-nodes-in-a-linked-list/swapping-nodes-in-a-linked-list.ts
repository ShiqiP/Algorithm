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
    // fast low pointer
    let first = head, second = head;
    for (let i = 1; i < k; i++) {
        first = first.next;
    }
    let firstTemp = first;

    // first starts from the kth step
    // second starts from the 1th step;
    while (first.next) {
        first = first.next;
        second = second.next;
    }
    // first reach to the end 
    // second points to the kth element from the end;

    [firstTemp.val, second.val] = [second.val, firstTemp.val];

    return head;
};