class Solution {
    class Pair {
        int row, col, step, eli;

        Pair(int row, int col, int step, int eli) {
            this.row = row;
            this.col = col;
            this.step = step;
            this.eli = eli;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] seen = new boolean[n][m][k+1];
        Queue<Pair> queue = new LinkedList<>();
        int[][] directs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        seen[0][0][k] = true;
        queue.add(new Pair(0, 0, 0, k));

        while (!queue.isEmpty()) {
            Pair cur = queue.remove();
            if (cur.row == n - 1 && cur.col == m - 1) {
                return cur.step;
            }
            for (int[] direct : directs) {
                int row = cur.row + direct[0], col = cur.col + direct[1];
                if (row >= 0 && row < n && col >= 0 && col < m) {
                    if (grid[row][col] == 1 && cur.eli > 0 &&  !seen[row][col][cur.eli-1]) {
                        queue.add(new Pair(row, col, cur.step + 1, cur.eli - 1));
                        seen[row][col][cur.eli - 1] = true;
                    }
                    if(grid[row][col] == 0 &&  !seen[row][col][cur.eli]){
                        queue.add(new Pair(row, col, cur.step + 1, cur.eli));
                        seen[row][col][cur.eli] = true;
                    }
                }
            }
        }
        return -1;
    }
}