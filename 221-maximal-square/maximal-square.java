class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n][m];
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    continue;

                arr[i][j] = Math.max(1, arr[i][j]);

                int min = Integer.MAX_VALUE;
                boolean flag = true;
                if (i - 1 >= 0 && arr[i - 1][j] > 0)
                    min = Math.min(min, arr[i - 1][j]);
                else
                    flag = false;
                if (j - 1 >= 0 && arr[i][j - 1] > 0)
                    min = Math.min(min, arr[i][j - 1]);
                else
                    flag = false;
                if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] > 0)
                    min = Math.min(min, arr[i - 1][j - 1]);
                else
                    flag = false;

                arr[i][j] += min != Integer.MAX_VALUE && flag ? min : 0;
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