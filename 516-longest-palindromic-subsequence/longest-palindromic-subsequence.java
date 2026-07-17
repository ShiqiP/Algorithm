class Solution {
    int[][] memo;
    String s;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // sequence before i and after j
        this.memo = new int[n][n];
        this.s = s;
        // b/bb/ab

        //
        return dp(0, n - 1);

    }

    public int dp(int start, int end) {
        if (memo[start][end] != 0)
            return memo[start][end];

        if (start > end)
            return 0;

        if(start == end)
            return 1;
            
        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = 2 + dp(start + 1, end - 1);
        } else {
            memo[start][end] = Math.max(dp(start + 1, end), dp(start, end - 1));
        }
        return memo[start][end];
    }
}