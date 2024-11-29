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
                dfs(i,seen,isConnected);
            }
        }
        return ans;
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