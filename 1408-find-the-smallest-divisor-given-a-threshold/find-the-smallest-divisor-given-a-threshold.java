class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // integer smallest divisor
        // bs
        int left = 1;
        int right = 0;
        for(int n : nums){
            right = Math.max(right,n);
        }

        while(left <= right){
            int mid = left + (right - left)/2;  
            int sum = 0;
            for(int n : nums){
                // 7/3 == 2  // 7/3 == 2.**
                sum += Math.ceil(n/(double) mid);
            }
            if(sum <= threshold){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}