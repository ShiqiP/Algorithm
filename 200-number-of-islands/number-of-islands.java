class Solution {
    boolean[][] visited;
    char[][] grid;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        int ans = 0;
        this.m = grid.length;
        this.n = grid[0].length;

        // Set<Integer> visited = new HashSet<>();
        this.visited = new boolean[m][n];
        this.grid = grid;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (!this.visited[i][j] && this.grid[i][j] == '1') {
                    dfs(i, j);
                    ans++;
                } else {
                    continue;
                }

            }
        }
        return ans;

    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= this.m || j < 0 || j >= this.n || this.visited[i][j] || this.grid[i][j] == '0')
            return;
        this.visited[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}