class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
     //leet code 
     // dp[end] = true;
     // dp[start - 1] && curr in the dic
     // leet, code
     // substring(start,end + 1)
        for(int end = 1; end <= len; end++){
            for(int start = end - 1; start >= 0; start--){
                if((start == 0 || dp[start - 1]) && set.contains(s.substring(start,end))){
                    dp[end - 1] = true;
                }
            }
        }
        return dp[len - 1];
    }
}