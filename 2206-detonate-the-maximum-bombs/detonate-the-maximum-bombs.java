class Solution {
    boolean[] seen;
    Map<Integer, List<Integer>> graph;

    public int maximumDetonation(int[][] bombs) {
        // graph maximum node of the connected component
        int n = bombs.length;

        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int[] cur = bombs[i];
                int[] next = bombs[j];
                double distance = Math.sqrt(Math.pow(cur[0] - next[0], 2) + Math.pow(cur[1] - next[1], 2));
                System.out.println(distance);
                System.out.println(cur[2]);
                if (distance <= cur[2]) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        seen = new boolean[n];
        int max = 1;
        for (int cur : graph.keySet()) {
            seen = new boolean[n];
            max = Math.max(max,dfs(cur));
        }
        return max;
    }

    public int dfs(int cur) {
        // System.out.println(cur);
        // System.out.println(graph.get(cur));
        if (graph.get(cur) == null)
            return 1;
        seen[cur] = true;
        int ans = 1;
        for (Integer i : graph.get(cur)) {
            if(!seen[i]){
                seen[i] = true;
                ans += dfs(i);
            }
        }
        return ans;
    }
}