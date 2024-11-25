class Solution {
    class State {
        int col, row, step;

        State(int row, int col, int step) {
            this.col = col;
            this.row = row;
            this.step = step;
        }

        public String toString() {
            return "row:" + row + " col:" + col + " step:" + step;
        }
    }

    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    boolean[][] seen;
    Queue<State> graph;

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        seen = new boolean[m][n];
        graph = new LinkedList<>();
        State entry = new State(entrance[0], entrance[1], 0);
        graph.add(entry);
        seen[entrance[0]][entrance[1]] = true;
        while (!graph.isEmpty()) {
            State cur = graph.remove();

            for (int[] direction : directions) {
                int x = direction[0], y = direction[1];
                int nextRow = x + cur.row, nextCol = y + cur.col;
                // System.out.println("---------");
                // System.out.println(nextRow + " " + nextCol);
                // System.out.println(isValid(nextRow, nextCol, m, n, maze));
                if (isValid(nextRow, nextCol, m, n, maze)) {
                    if (nextRow == 0 || nextRow == m - 1 || nextCol == 0 || nextCol == n - 1) {
                        return cur.step + 1;
                    }
                    seen[nextRow][nextCol] = true;
                    graph.add(new State(nextRow, nextCol, cur.step + 1));
                }
            }
        }
        return -1;
    }

    public boolean isValid(int row, int col, int m, int n, char[][] maze) {
        return row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == '.' && !seen[row][col];
    }
}