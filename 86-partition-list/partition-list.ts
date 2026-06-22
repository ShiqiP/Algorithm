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

function partition(head: ListNode | null, x: number): ListNode | null {
    let dummy = new ListNode(-300, head);
    let smallNode = dummy;
    let largeStart = null;
    let largeEnd = null;
    let node = head;
    // insert the node between small and largeNode
    // update smallNode 
    // largeEnd.next = node.next;

    while (node) {
        console.log(node.val)
        if (node.val < x) {
            if (largeStart === null) smallNode = node;
            else {
                let next = node.next;
                // console.log("next" + next?.val)
                smallNode.next = node;
                node.next = largeStart;
                smallNode = node;
                largeEnd.next = next;
                node = next;
                continue
            }
        } else {
            if (largeStart === null) { largeStart = node; largeEnd = node; }
            else largeEnd = node;
        }
        node = node.next;

    }

    function insert(node: ListNode, start: ListNode, end: ListNode) {

    }
    return dummy.next;
};