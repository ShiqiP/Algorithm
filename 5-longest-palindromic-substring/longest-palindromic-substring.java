class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] arr = new int[] { 0, 0 };
        /**
        i,i;
        
         */
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // aaab
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                arr[0] = i;
                arr[1] = i + 1;
            }
        }
        // abbbba
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return s.substring(arr[0], arr[1] + 1);

    }

}