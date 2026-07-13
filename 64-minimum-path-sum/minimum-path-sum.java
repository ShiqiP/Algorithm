class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minSum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    minSum[i][j] = grid[i][j];
                else if (j == 0 && i != 0)
                    minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                else if (i == 0 && j != 0)
                    minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                else
                    minSum[i][j] +=  grid[i][j] + Math.min(minSum[i][j - 1], minSum[i - 1][j]);
            }
        }
        return minSum[m - 1][n - 1];
    }
}