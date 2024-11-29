class Solution {
    boolean[] seen;
    Map<Integer,List<Integer>> graph;

    public int findCircleNum(int[][] isConnected) {
        // find the number of connected conponents
        int n = isConnected.length;
        // convert adjacency matrix to map
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = i + 1; j < n; j++) {
                // undirected graoh;
                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

            }
        }
        int ans = 0;
        // seen to keep track of the node we visited
         seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                seen[i] = true;
                ans++;
                dfs(i);
            }
        }
        return ans;
    }

    public void dfs(int node) {
        // we execute dfs to visit all the directly and indirectly connected node
        for (int i : graph.get(node)) {
            if (!seen[i]) {
                seen[i] = true;
                dfs(i);
            }
        }
    }
}