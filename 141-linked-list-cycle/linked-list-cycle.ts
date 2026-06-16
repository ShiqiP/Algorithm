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
    
    let set = new Set();

    let current: ListNode = head;

    while(current !== null){
        
        if(set.has(current)) return true;

        set.add(current);

        current = current.next;

    }

    return false;
};