class Solution {
    public int uniquePaths(int m, int n) {

        int[][] visit = new int[m][n];

        // visit[0][0] = 1;
        // visit[0][1] = 1;
        // visit[1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    visit[i][j] = 1;
                else
                    visit[i][j] = visit[i - 1][j] + visit[i][j - 1];
            }
        }

        return visit[m - 1][n - 1];
    }
}