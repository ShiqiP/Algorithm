class Solution {
    boolean[][] seen;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        // convert adjacency matrix to hashMap
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    // seen[i][j] = true;
                    int temp  = dfs(i, j, grid,0);
                    ans = Math.max(ans,temp);

                }
            }
        }

        return ans;
    }

    public int dfs(int row, int col, int[][] grid,int num) {
        
        if (row < 0 || row >= m || col < 0 || col >= n){
            return 0;
        }
        if (seen[row][col] || grid[row][col] == 0) {
            return 0;

        }
        
        seen[row][col] = true;
        
        int total = 1;

        total += dfs(row+1,col,grid, num);        
        total += dfs(row-1,col,grid, num);
        total += dfs(row,col+1,grid, num);
        total += dfs(row,col-1,grid, num);

        
        return total;
    }
}