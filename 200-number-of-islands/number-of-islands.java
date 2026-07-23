class Solution {
    boolean[][] visited;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        int ans = 0;
        // dfs to traverse all the islands
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid) {
        // base cases
        if (i < 0 || i >= this.m || j < 0 || j >= this.n || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // 4 directions
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}