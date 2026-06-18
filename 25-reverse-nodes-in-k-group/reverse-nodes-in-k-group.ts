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
    while (i < k - 1 && node) {
        node = node.next;
        i++;
    }

    // if not enough k nodes, no reversal and return head;
    if (node === null) return head;

    // reserve next 
    let next: ListNode = reverseKGroup(node.next, k);
    // reverse
    reverse(head, k);
    // 
    // console.log("next:" + next.val)
    // console.log("head:" + head.val)
    head.next = next
    return node;

    function reverse(head: ListNode, k: number){
        let node = head;
        let pre = null;
        let next = null;
        let i = 0;
        console.log("+--------+")
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
    }
};