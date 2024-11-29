class Solution {
    class Pair{
        int row,col,step;
        Pair(int row, int col, int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        // matrix we don't know the exact neighbors
        int[][] directs = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] seen = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // bfs start from 0,0
        queue.add(new Pair(0,0,1));
        seen[0][0] = true;
        while(!queue.isEmpty()){
            Pair cur = queue.remove();
            // if we reach to the bottom-right return step;
            if(cur.row == n-1 && cur.col == m-1)
                return cur.step;

            // visit all it's directly connected neighbors;
            for(int[] direct : directs){
                int col = cur.col + direct[0] , row = cur.row + direct[1];
                if(row>=0 && row<n && col>=0 && col<m && grid[row][col] == 0 && !seen[row][col]){
                    queue.add(new Pair(row,col,cur.step + 1));
                    seen[row][col] = true;
                }
            }
        }
        return -1;

    }
}