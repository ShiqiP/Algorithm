class Solution {
    boolean[] seen;
    Map<Integer,List<Integer>> graph;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // convert the array of edges to hashMap
        // seen to keep track of the node we visited
        // travese every node if it's not seen then we add the node to the List;
        graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(List<Integer> list:edges){
            int start = list.get(0),end = list.get(1);
            // directed graph
            graph.get(start).add(end);
        }
        seen = new boolean[n];
        // List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n;i++){
            if(!seen[i]){
                seen[i] = true;
                set.add(i);
                dfs(i,set);
            }
        }
        return new ArrayList<>(set);
    }
    public void dfs(int node,Set<Integer> set){
        for(int i:graph.get(node)){
            if(!seen[i]){
                seen[i] = true;
                dfs(i,set);
            }else{
                set.remove(i);
            }
        }
    }
}