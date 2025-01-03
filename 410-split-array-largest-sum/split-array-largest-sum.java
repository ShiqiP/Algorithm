class Solution {
    public int splitArray(int[] nums, int k) {
        // the question want me to split k subarray in which the sum of elements is minimized
        // the sum of each subarray is larger than or equal to the average which is sum of nums divided by k

        // largest sum 
        int right = 0;
        int left = 0;
        for(int n : nums){
            right += n;
            left = Math.max(left,n);
        }

        int ans = 0;
        while(left <= right){
            int mid = left + (right - left )/2;

            int sum = 0;
            int chunks = 1;
            for(int n : nums){
                if(sum + n <= mid){
                    sum += n;
                }else{
                    sum = n;
                    chunks ++;
                }
            }

            if(chunks <= k){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans; 
    }
}