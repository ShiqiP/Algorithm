class Solution {
    int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
    int[][] visited;

    public int totalNQueens(int n) {
        int ans = 0;

        // begin row=0 col= 0~j;
        for (int j = 0; j < n; j++) {
            this.visited = new int[n][n];
            int temp = backtrack(0, 0, j, n, 0);
            System.out.println(temp);
            ans += temp;
        }
        return ans;
        // graph
        // backtraking
        // queen can move any number diagonally, vertically, horizontally
        // 2d array row col -> position
        // we can not place the next queen in same row col (row-1 col-1)
    }

    public void handleVisited(int row, int col, int n, int direct, int gap) {
        // System.out.println("visit " + row + "," + col);
        if (row >= n || row < 0 || col < 0 || col >= n)
            return;
        this.visited[row][col] += gap;
        // go further
        handleVisited(row + directions[direct][0], col + directions[direct][1], n, direct, gap);

    }

    public int backtrack(int total, int row, int col, int n, int ans) {
        // choos one position then we initialize the visited
        // go to the next row if the next position has not been visited means we can
        // place the queen here total ++
        // go to the next step
        // once the total is equal to n means we have one solutions
        int result = ans;
        int queens = total;

        if (this.visited[row][col] <= 0) {
            for (int z = 0; z < this.directions.length; z++) {
                this.visited[row][col] += 1;
                this.handleVisited(row + this.directions[z][0], col + this.directions[z][1], n, z, 1);
            }
            queens++;
        } else {
            return result;
        }

        if (queens == n) {
            return result + 1;
        }

        for (int j = 0; j < n; j++) {
            if (this.visited[row + 1][j] <= 0) {
                int nextRow = row + 1;
                result = backtrack(queens,nextRow , j, n, result);
                for (int z = 0; z < this.directions.length; z++) {
                    this.visited[nextRow][j] -= 1;
                    this.handleVisited(nextRow + this.directions[z][0], j + this.directions[z][1], n, z, -1);
                }
            }
        }
        return result;
    }

}