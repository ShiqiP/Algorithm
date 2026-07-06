/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node dummy;
    Node node;

    public Node treeToDoublyList(Node root) {
        dummy = new Node(0);
        node = dummy;
        preOrder(root);

        if (node != null && dummy.right != null) {
            node.right = dummy.right;
            dummy.right.left = node;
        }
        return dummy.right;
    }

    public void preOrder(Node root) {
        if (root == null)
            return;

        preOrder(root.left);

        node.right = root;
        root.left = node;

        node = node.right;

        preOrder(root.right);

    }
}