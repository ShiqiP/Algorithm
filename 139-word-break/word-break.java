class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((i == 0 || dp[i]) && words.contains(s.substring(i, j))) {
                    dp[j] = true;
                    // break;
                }
            }
        }
        return dp[n];
    }
}