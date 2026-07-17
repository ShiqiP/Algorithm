class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // sequence before i and after j
        int mid = n / 2;
        int[][] memo = new int[n][n];
        // bb b ab
        // 01 2 34
        //
        for (int i = n - 1; i >= 0; i--) {
            memo[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] += memo[i + 1][j - 1] + 2;
                }else{
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j-1]);
                }
            }

        }
        return memo[0][n - 1];

    }
}