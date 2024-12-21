class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // bigger success/potion
        // sort potions bs smallest one that meet above condition , i
        // how many potions meet above condition  potions.length - i
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            // float has decimal part 
            int s = spells[i];
            double target = success/ (double) s;
            int left=0, right=potions.length;
            while(left < right){
                int mid = left + (right-left)/2;
                if(potions[mid] >= target){
                    right = mid;
                }else {
                    left = mid +1;
                }
            }
            ans[i] = potions.length-left;
        }
        return ans;
    }
}