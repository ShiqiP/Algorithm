class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1 max
        int left = 1,right=0;
        for(int bananas:piles){
            right = Math.max(right,bananas);
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            int sum = 0;
            for(double bananas:piles){
                sum += Math.ceil(bananas/mid);
            }
            if(sum > h){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}