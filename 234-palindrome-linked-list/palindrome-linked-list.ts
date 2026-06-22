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
    //  fast slow 
    // slow points to the mid of the list
    // reverse the head to slow 
    // compare the val slow.next pre.next 
    let fast = head;
    let slow = head;
    let pre = null;
    let current = head;
    // 1 2 3 /4 5 6 if slow in the mid fast === null
    // 1 2 /3 4 5 if slow in the mid fast points to the tail
    while (fast?.next) {
        slow = slow.next;
        fast = fast.next.next;

        current.next = pre;
        pre = current;
        current = slow;
    }

    if (fast) slow = slow.next;

    while (pre) {
        if (pre.val !== slow.val) return false;
        pre = pre.next;
        slow = slow.next;
    }
    return true;
};