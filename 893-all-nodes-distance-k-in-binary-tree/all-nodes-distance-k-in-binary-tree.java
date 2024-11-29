/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // only have one parent so just store one node
    Map<TreeNode, TreeNode> graph;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // we convert this tree problem to a undirected graph problem
        // noticed that parent have the pointer to it's children but children don't
        // so we traverse tree to add parent to the children's neighbor;
        graph = new HashMap<>();
        treeDfs(root, null);

        // find the K distance so we use BFS
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        int index = 0;
        // start from target;
        queue.add(target);
        set.add(target);
        while (!queue.isEmpty() && index < k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                for (TreeNode neighbor : new TreeNode[] { cur.left, cur.right, graph.get(cur) }) {
                    if (neighbor != null && !set.contains(neighbor)) {
                        queue.add(neighbor);
                        set.add(neighbor);
                    }
                }

            }
            index++;
        }
        for (TreeNode node : queue) {
            ans.add(node.val);
        }
        return ans;
    }

    public void treeDfs(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        treeDfs(node.left, node);
        treeDfs(node.right, node);
        graph.put(node, parent);
    }
}