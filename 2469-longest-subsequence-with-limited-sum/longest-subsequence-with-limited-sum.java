class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);  
        int[] ans = new int[queries.length];
        // presum
        for(int i=1; i<nums.length ;i++){
            nums[i] += nums[i-1];
        }        
        for(int i=0;i<queries.length;i++){
            int left=0,right=nums.length-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(queries[i] == nums[mid]){
                    left =  mid+1;
                    break;
                }else if(queries[i] < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }
            ans[i] = left<nums.length ? nums[left] < queries[i] ? left-1:left : left;
        }
        return ans;
    }
}