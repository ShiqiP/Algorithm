class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // is a adjacency list 
        // we can access all the neighbors of the node from the input;
        // use dfs to search the graph 
        // if begin from 0 and find the number of it's directly or indirectly connected neighbors
        // equals to the number of rooms then return true;
        int n = rooms.size();
        boolean[] seen = new boolean[n];
        int num = 0;

        seen[0] = true;
        num += 1+dfs(0,seen,rooms);

        return num == n;
    }
    public int dfs(int cur, boolean[] seen,List<List<Integer>> rooms){
        int ans = 0;
        for(int n:rooms.get(cur)){
            if(!seen[n]){
                seen[n] = true;
                ans += 1+ dfs(n,seen,rooms);
            }
        }
        return ans;
    }   
}