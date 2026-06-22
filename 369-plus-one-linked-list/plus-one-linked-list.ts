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

function plusOne(head: ListNode | null): ListNode | null {
    let stack: Array<ListNode> = [];
    let node: ListNode = head;

    while (node) {
        stack.push(node);
        node = node.next;
    }

    let flag: boolean = true;

    while (flag && stack.length > 0) {
        let node = stack.pop();
        flag = (node.val + 1) > 9 ? true : false;
        node.val = flag ? 0 : node.val + 1;
    }


    return flag ? new ListNode(1, head) : head;
};