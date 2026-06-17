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

/**
 Do not return anything, modify head in-place instead.
 */
function reorderList(head: ListNode | null): void {
    // stack push n
    let stack = new Array<ListNode>();
    let node = head;
    while(node){
        stack.push(node);
        node = node.next;
    }
    
    let pre = new ListNode(0);
    // head node.next point to the stack.pop 
    // until node === stack.pop
    while(stack.length != 0){
        
        node = stack.shift();
        console.log("node: " + node.val);
        node.next = stack.pop() ?? null;
        console.log("node.next:" +  node.next?.val);
        pre.next = node;
        pre = node.next;
        console.log("pre:" +  pre?.val);
    }
    if(pre) pre.next = null;
};