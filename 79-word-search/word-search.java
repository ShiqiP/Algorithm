class Solution {
    int n, m, len;
    boolean[] used;

    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.len = n * m;
        this.used = new boolean[this.len];

        return backtracking(-1, 0, board, word);
    }

    public boolean backtracking(int pre, int pos, char[][] board, String word) {

        if (pos == word.length())
            return true;
        int position = pos;

        for (int i = 0; i < this.len; i++) {
            int row = i / m;
            int col = i % m;
            int preRow = pre == -1 ? row : pre / m;
            int preCol = pre == -1 ? col : pre % m;
            // System.out.println("----------");
            // System.out.println(row + "," + col);
            // System.out.println(preRow + "," + preCol);

            if (!this.used[i]
                    && ((row == preRow && Math.abs(col - preCol) <= 1)
                            || (col == preCol && Math.abs(row - preRow) <= 1))
                    && board[row][col] == word.charAt(position)) {
                this.used[i] = true;
                // System.out.println(position + " " + i + " " + board[row][col]);
                position++;
                if (!backtracking(i, position, board, word)) {
                    this.used[i] = false;
                    position--;
                } else {
                    return true;
                }

            }
        }
        return position == word.length();
    }
}