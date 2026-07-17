class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];

        for(int end = 0; end < len; end++){
            for(String word : wordDict){

                int length = word.length();
                // 0  4
                if(end + 1 < length) continue;

                int start = end - length + 1;

                if( (start == 0|| dp[start - 1]) && s.substring(start, end + 1).equals(word)){
                    dp[end] = true;
                }
            }       
        }

        return dp[len - 1];
    }
}