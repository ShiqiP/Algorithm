/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Integer, Node> map = new HashMap<>();

    /**
     * 

     map 
     1 -> Node(1, [])
     2 -> Node(2, [1, ])
     3 -> Node(3, [2, ])
     4 -> Node(4, [])

     */

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);

        List<Node> neighbors = node.neighbors;

        // List<Node> copyNeighbors = new ArrayList<>();
        Node copyNode = new Node(node.val);
        // copyNode.neighbors = copyNeighbors;

            map.put(node.val, copyNode);


        // dfs from node
        for (Node n : neighbors) {
            Node newNode = cloneGraph(n);
           copyNode.neighbors.add(newNode);
        }

        // set to track the node has been created
        return copyNode;

    }
}