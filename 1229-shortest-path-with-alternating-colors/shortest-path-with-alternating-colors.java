class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // convert a map graph the neighbors list contains another list, list[0] is
        // neighbor list[1] is it's color
        // 0-red 1-blue
        // 0 -> [[1,0]]
        // 1 -> [[2,0]]
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] r : redEdges) {
            graph.get(r[0]).add(Arrays.asList(r[1], 0));
        }
        for (int[] b : blueEdges) {
            graph.get(b[0]).add(Arrays.asList(b[1], 1));
        }
        int[] ans = new int[n];
        boolean[][] seen = new boolean[n][2]; // each node has two color 
        Arrays.fill(ans,-1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,-1}); // 0-node 1-step 2-color
        ans[0] = 0;
        seen[0][0] = true;
        seen[0][1] = true;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            int node = cur[0], step = cur[1], preColor=cur[2];
            for(List<Integer> nei : graph.get(node)){
                int val = nei.get(0), color=nei.get(1);
                if(!seen[val][color] && preColor!=color){
                    if(ans[val] == -1){
                        ans[val] = step+1 ;
                    }
                    seen[val][color] = true;
                    q.add(new int[]{val,step+1,color});
                }
            }
        }
        return ans;
    }
}