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

    let count = 0;
    let dummy = new ListNode(-1);
    dummy.next = head;
    let list1tail = dummy;
    while (count < left - 1) {
        list1tail = list1tail.next;
        count++;
    }

    let list2Head = list1tail.next;
    let current = list2Head;
    let pre = null;

    while (count < right) {
        let next = current.next;

        current.next = pre;

        pre = current;
        current = next;

        count++;
    }

    list1tail.next = pre;
    list2Head.next = current;

    return dummy.next;
};