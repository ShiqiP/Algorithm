class Solution {
    class Pair{
        int row,col,step;
        Pair(int row, int col, int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
       // is a matrix have n*m nodes;
       // find the distance of nearest 0 for each cell
       // indicate using BFS to traverse graph
        int n = mat.length;
        int m = mat[0].length;
        int[][] directs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] seen = new boolean[n][m];  
        Queue<Pair> queue = new LinkedList<>();
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    seen[i][j] = true;
                    ans[i][j] = 0;
                    queue.add(new Pair(i,j,1));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair cur = queue.remove();
            for(int[] direct : directs){
                int row = cur.row + direct[0], col = cur.col + direct[1];
                if(row>=0 && row<n && col>=0 && col<m && !seen[row][col] ){
                    ans[row][col] = cur.step;
                    seen[row][col] = true;
                    queue.add(new Pair(row,col,cur.step+1));
                }

            }
        }
        return ans;
    }   
}