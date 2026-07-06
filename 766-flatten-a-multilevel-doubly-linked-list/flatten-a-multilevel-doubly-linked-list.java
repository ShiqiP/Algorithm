/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node dummy;
    Node curr;

    public Node flatten(Node head) {
        dummy = new Node();
        curr = dummy;
        dfs(head);
        if(dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }

    public void dfs(Node root) {
        if (root == null)
            return;
        // frist point to the root
        Node next = root.next;
        curr.next = root;
        root.prev = curr;
        curr = curr.next;
        // its child
        dfs(root.child);
        // its next
        dfs(next);
        root.child = null;
    }
}