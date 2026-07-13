class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n + 1][m + 1];
        int len = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '0')
                    continue;

                int min = Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1]);
                arr[i][j] = 1 + min;
                len = Math.max(len, arr[i][j]);
                // 3 / 3 = 1 
                // 6 / 3 = 2
                // 5 / 3 = 1 

            }
            /**
            [["1","1","1","1","0"],
            ["1","2","1","1","0"],
            ["1","1","1","1","1"],
            ["1","1","1","1","1"],
            ["0","0","1","1","1"]]
             */

        }
        // for (int[] row : arr) {
        //     System.out.println("");
        //     for (int val : row) {
        //         System.out.print(val + ",");
        //     }
        // }
        return len * len;
    }
}