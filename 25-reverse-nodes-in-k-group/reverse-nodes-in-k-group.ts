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
    // 1 2 3 4 5 , 2
    // 2 1 4 3 5

    let length = 0;
    let node = head;
    let newHead = null;

    while (node) {
        node = node.next;
        length++;
    }

    let times = Math.floor(length / k);

    let pre = null;
    let current = head;
    let tail = new ListNode(-1); // 1



    for (let i = 0; i < times; i++) {

        // tail = current;
        let originHead = current;

        for (let j = 0; j < k; j++) {

            let next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }
        if (newHead === null) newHead = pre // the head of the reversed List

        tail.next = pre;
        tail = originHead;
    }
    tail.next = current;
    return newHead;
};