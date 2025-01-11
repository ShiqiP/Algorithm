class Solution {
    int n, m, len;
    boolean[][] used;
    int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.len = n * m;
        this.used = new boolean[this.n][this.m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, int index, char[][] board, String word) {
        if (index >= word.length())
            return true;

        if (row < 0 || row == n || col < 0 || col == m || board[row][col] != word.charAt(index) || this.used[row][col])
            return false;

        for (int[] direct : this.directions) {
            int nextRow = row + direct[0];
            int nextCol = col + direct[1];

            this.used[row][col] = true;
            if( backtrack(nextRow, nextCol, index + 1, board, word)){
                return true;
            }
            this.used[row][col] = false;
        }
        return false;
    }
}