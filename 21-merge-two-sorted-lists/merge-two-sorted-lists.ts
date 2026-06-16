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

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    let head: ListNode = new ListNode(0);
    let pre = head;
    while (list1 && list2) {
        if (list1.val < list2.val) {
            pre.next = list1;
            list1 = list1.next;
        } else {
            pre.next = list2;
            list2 = list2.next;
        }
        pre = pre.next;
    }

    if (list1) pre.next = list1;
    if (list2) pre.next = list2;

    return head.next;
};