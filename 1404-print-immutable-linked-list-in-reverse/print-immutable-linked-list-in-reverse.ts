/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ImmutableListNode {
 *      printValue() {}
 *
 *      getNext(): ImmutableListNode {}
 * }
 */

function printLinkedListInReverse(head: ImmutableListNode) {
    let stack = [];
    let node = head;
    while (node) {
        stack.push(node);
        node = node.getNext();
    }

    while(stack.length > 0){
        stack.pop().printValue();
    }
};