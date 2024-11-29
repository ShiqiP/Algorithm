class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    int n, m;

    public int numIslands(char[][] grid) {
        // to calculate the number of connected components;
        // we can not access neighbors directlt from the input
        // noticed that the neighbors is from the top/bottom/left/right;
        n = grid.length;
        m = grid[0].length;
        boolean[][] seen = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    ans++;
                    dfs(i, j, seen, grid);
                }
            }
        }
        return ans;
    }

    public boolean isValid(int row, int col) {
        return col >= 0 && col < m && row >= 0 && row < n;
    }

    public void dfs(int row, int col, boolean[][] seen, char[][] grid) {
        // all the neighbors of node
        seen[row][col] = true;
        for (int[] direc : directions) {
            int x = row + direc[0], y = col + direc[1];
    
            if (isValid(x, y) && !seen[x][y] && grid[x][y] == '1') {
                seen[x][y] = true;
                dfs(x, y, seen, grid);
            }
        }
    }
}