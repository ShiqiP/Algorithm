class Solution {

    public int findCircleNum(int[][] isConnected) {
        // find the number of connected conponents
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int ans=0;
        for(int i=0; i<n; i++){
            if(!seen[i]){
                seen[i] = true;
                ans ++;
                bfs(i,seen,isConnected);
            }
        }
        return ans;
    }
    public void bfs(int i, boolean[] seen, int[][] isConnected){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(int j=0; j<isConnected.length; j++){
                if(!seen[j] && isConnected[cur][j] == 1){
                    queue.add(j);
                    seen[j] = true;
                }
            }
        }
    }
    public void dfs(int i, boolean[] seen, int[][] isConnected){
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !seen[j] ){
                seen[j] = true;
                dfs(j,seen,isConnected);
            }
        }
    }
}