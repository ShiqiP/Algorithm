class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;

        if(n < 2) return matrix[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){

                int min = matrix[i - 1][j];
                if(j - 1 >= 0)
                    min = Math.min(min, matrix[i - 1][j - 1]);
                if(j + 1 < n)
                    min = Math.min(min,  matrix[i - 1][j + 1]);
                
                matrix[i][j] += min;
               
               if(i == n - 1)
                ans = Math.min(ans, matrix[i][j]);
            }
        }
        return ans;
    }
}