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

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    /**
    l1 the tail of list1   l1t.next = l2h
    l2 the tail of list2  
    l3 the head of list3
     */
    // let l1t: ListNode, l2t: ListNode, l3h: ListNode;
    let count = 0;
    let dummy = new ListNode(-1);
    dummy.next = head;
    let l1t = dummy;
    while (count < left - 1) {
        l1t = l1t.next;
        count++;
    }

    let list2Head = l1t.next;
    let current = list2Head;
    let pre = null;

    while (count < right) {
        let next = current.next;

        current.next = pre;

        pre = current;
        current = next;

        count++;
    }

    l1t.next = pre;
    list2Head.next = current;

    return dummy.next;
};