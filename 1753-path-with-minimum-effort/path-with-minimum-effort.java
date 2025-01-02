class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    boolean[][] visited;
    int m;
    int n;

    public int minimumEffortPath(int[][] heights) {
        // bs graph dfs
        // 1. maximum number of the input
        int left = 0, right = 0;
        this.m = heights.length;
        this.n = heights[0].length;

        for (int[] row : heights) {
            for (int el : row) {
                right = Math.max(right, el);
            }
        }
        //
        while (left <= right) {
            int mid = left + (right - left) / 2;
            this.visited = new boolean[this.m][this.n];
            if (dfs(0, 0, heights, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean dfs(int row, int col, int[][] heights, int effort) {
        this.visited[row][col] = true;
        if (row == this.m - 1 && col == this.n - 1) {
            return true;
        }
        for (int[] direction : this.directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < this.m && nextCol >= 0 && nextCol < this.n
                    && !this.visited[nextRow][nextCol]) {
                if (Math.abs(heights[nextRow][nextCol] - heights[row][col]) <= effort) {
                    if (dfs(nextRow, nextCol, heights, effort))
                        return true;
                }
            }
        }
        return false;
    }
}