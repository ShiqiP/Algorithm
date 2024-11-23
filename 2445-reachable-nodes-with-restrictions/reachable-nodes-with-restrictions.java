class Solution {
    Map<Integer,List<Integer>> graph;
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int ans = 0;
        graph = new HashMap<>();
        seen = new boolean[n];
        // convert array of edges to hashMap
        for(int[] edge:edges){
            int x = edge[0], y = edge[1];
            // boolean flag = Arrays.stream(restricted).anyMatch(z -> {return (z == x || z == y); });
            // if(flag) continue;

            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
            }
            graph.get(x).add(y);
            
            // undirected
            if(!graph.containsKey(y)){
                graph.put(y,new ArrayList<>());
            }
            graph.get(y).add(x);
        }
        for(int i:restricted){
            seen[i] = true;
        }
        return findMax(0,1,restricted);
    }
    public int findMax(int node, int num ,int[] restricted){
        int total = num;
        seen[node] = true;
        for(int n:graph.get(node)){
            // boolean flag = Arrays.stream(restricted).anyMatch(x -> {return x == n});
            // if(flag && !seen[n]){
            //     seen[n] = true;
            // }
            if(!seen[n]){
                seen[n] = true;
                total = 1 + findMax(n,total,restricted);
             }
        }
        return total;
    }
}