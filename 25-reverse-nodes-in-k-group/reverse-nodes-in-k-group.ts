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

function reverseKGroup(head: ListNode | null, k: number): ListNode | null {

    // base case   
    if (head === null) return head;

    // verify if there are at least k nodes left
    let node: ListNode = head;
    let i = 0;
    while (i < k && node) {
        node = node.next;
        i++;
    }

    // if not enough k nodes, no reversal and return head;
    if (i !== k ) return head;

    // reverse
    let reversedHead = reverse(head, k);

    // reverse
    head.next =  reverseKGroup(node, k);

    return reversedHead;

    function reverse(head: ListNode, k: number): ListNode {
        let node = head;
        let pre = null;
        let next = null;
        let i = 0;
        while (i < k && node) {

            // reserve next
            next = node.next;

            // reverse
            node.next = pre;

            // point to next node
            pre = node;
            node = next;
            i++;
        }
        return pre;
    }
};