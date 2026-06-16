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
    // FASE SLOW

    let low : ListNode = head;
    let fast : ListNode = head;

    while(fast && fast.next){
        fast = fast.next.next;
        low = low.next;
        if(fast === low){
            return true;
        }
    }    
    return false;
};