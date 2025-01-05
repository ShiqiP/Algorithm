class Solution {
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        this.n = graph.length;
        backtracking(0,new ArrayList<>(), graph, ans);

        return ans;
    }
    public void backtracking(int node, List<Integer> cur, int[][] graph, List<List<Integer>> ans){
        cur.add(node);
        if(node == this.n-1){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0; i<graph[node].length; i++){
            int nextNode = graph[node][i];
            backtracking(nextNode,cur,graph,ans);
            cur.remove(cur.size()-1);
        }
    }
}