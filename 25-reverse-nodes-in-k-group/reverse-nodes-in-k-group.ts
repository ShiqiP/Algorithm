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

    let node: ListNode = head;
    let newHead: ListNode = null;
    let pre: ListNode = null;

    while (node !== null) {

        // verify if there are at least k nodes left
        let temp = node;
        let i = 0;
        while (i < k && temp) {
            temp = temp.next;
            i++;
        }
        if (i !== k) {
            if (pre) pre.next = node;
            break;
        }

        let reversedHead: ListNode = reverse(node, k);

        if (newHead === null) newHead = reversedHead;
        if (pre !== null) pre.next = reversedHead;

        pre = node;
        node = temp;

    }

    return newHead;


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