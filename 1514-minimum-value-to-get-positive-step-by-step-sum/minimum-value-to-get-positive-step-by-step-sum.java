class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        int max = 1 - prefix[0];
        for(int i:prefix){
            max = Math.max(max, 1 - i);
        }
        return max <=0 ? 1:max;
    }
}