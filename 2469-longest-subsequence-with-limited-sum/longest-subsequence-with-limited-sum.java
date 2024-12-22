class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);  
        int len = queries.length;
        int[] ans = new int[len];

        for(int i=0; i<len; i++){
            int index = 0;
             long sum = 0;
            while(sum < queries[i] && index < nums.length){
                sum += nums[index];
                index++;
            }  
            if(sum > queries[i] &&index>0){
                index--;
            }
            ans[i] = index;
        }
        return ans;
    }
}