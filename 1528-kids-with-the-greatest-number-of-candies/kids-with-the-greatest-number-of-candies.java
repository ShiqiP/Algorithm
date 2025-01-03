class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 1. maximum number of the candies array
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for(int c : candies){
            max = Math.max(max,c);
        }
        for(int index=0; index<candies.length; index++){
            ans.add(max <= candies[index] + extraCandies);
        }
        return ans;
    }
}