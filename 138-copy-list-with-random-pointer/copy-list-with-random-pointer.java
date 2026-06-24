/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        if (this.map.containsKey(head))
            return map.get(head);
        // set 1,2
        // [1]  [2,2]
        Node node = new Node(head.val);
        this.map.put(head, node);

        node.random = copyRandomList(head.random);
        node.next = copyRandomList(head.next);

        return node;
    }

}