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
    let node1 = list1, node2 = list2;
    let ans = null, node = null;
    while (node1 && node2) {
        if (node1.val < node2.val) {
            if (node) {
                node.next = node1;
                node = node.next;
            } else {
                node = node1;
            }
            node1 = node1.next;
        } else {
            if (node) {
                node.next = node2;
                node = node.next;
            } else {
                node = node2;
            }
            node2 = node2.next;

        }
        if (!ans) ans = node;
    }
    if (node1) node ? (node.next = node1) : (node = node1);
    if (node2) node ? (node.next = node2) : (node = node2);
   if (!ans) ans = node;
    return ans;
};