/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // traverse the list find the node that is smaller than inserval

        // insert it until find the next node is bigger than inserVal
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node pre = head;
        Node node = head.next;
        boolean toInsert = false;

        do {
            if (pre.val <= insertVal && insertVal <= node.val) {
                toInsert = true;
            } else if (pre.val > node.val) {
                if (pre.val <= insertVal || insertVal <= node.val) {
                    toInsert = true;
                }
            }
            if (toInsert) {
                pre.next = new Node(insertVal, node);
                return head;
            }
            pre = node;
            node = node.next;
        } while (pre != head);

        pre.next = new Node(insertVal, node);
        return head;
    }
}