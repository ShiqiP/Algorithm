class Solution {
    int[][] dp;

    public int minDistance(String word1, String word2) {
        int word1len = word1.length();
        int word2len = word2.length();
        dp = new int[word1len + 1][word2len + 1];

        return minDistance(word1, word2,word1len , word2len);
    }

    public int minDistance(String word1, String word2, int word1Index, int word2Index) {
        if (word1Index == 0)
            return word2Index;

        if (word2Index == 0)
            return word1Index;
        
        if(dp[word1Index][word2Index] != 0){
            return dp[word1Index][word2Index];
        }

        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1))
            dp[word1Index][word2Index] =  minDistance(word1, word2, word1Index - 1, word2Index - 1);
        else {
            int insertNum = minDistance(word1, word2, word1Index, word2Index - 1);
            int deleteNum = minDistance(word1, word2, word1Index - 1, word2Index);
            int repaliceNum = minDistance(word1, word2, word1Index - 1, word2Index - 1);
            dp[word1Index][word2Index] =  Math.min(insertNum, Math.min(deleteNum, repaliceNum)) + 1;
        }
        return dp[word1Index][word2Index];

    }
}